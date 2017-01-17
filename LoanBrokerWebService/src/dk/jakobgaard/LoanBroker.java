package dk.jakobgaard;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.webservice.bank.LoanResponse;
import dk.jakobgaard.clients.banks.Bank;
import dk.jakobgaard.clients.banks.MessagingBank;
import dk.jakobgaard.clients.banks.WebServiceBank;
import dk.jakobgaard.clients.credit.CreditService;
import dk.jakobgaard.clients.credit.CreditServiceHandler;
import dk.jakobgaard.clients.rulebase.IRulebaseService;
import dk.jakobgaard.clients.rulebase.RulebaseServiceHandler;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebService()
public class LoanBroker {
    private CreditService creditService;
    private IRulebaseService rulebaseService;
    private Map<String, Bank> banks;
    private Gson gson;

    public LoanBroker() throws IOException {
        this(new CreditServiceHandler(), new RulebaseServiceHandler());
    }

    public LoanBroker(CreditService creditService, IRulebaseService rulebaseService) {
        this.creditService = creditService;
        this.rulebaseService = rulebaseService;
        this.banks = getBanks();
        this.gson = new GsonBuilder().create();
    }

    // Little builder function that builds a map with the name as a key
    // and the actual bank and how to contact it as a value
    private Map<String, Bank> getBanks() {
        Map<String, Bank> banks = new HashMap<>();
        banks.put("Goldmann Sachs", new MessagingBank("JSON", "cphbusiness.bankJSON", "fanout"));
        banks.put("Chill Bank", new MessagingBank("XML", "cphbusiness.bankXML", "fanout"));
        banks.put("Vivus", new WebServiceBank("JSON"));
        return banks;
    }

    @WebMethod
    public String fileLoanRequest(String ssn, double loanAmount, long loanDuration) {
        int creditScore = creditService.getCreditScore(ssn);
        if (creditScore < 0) {
            return "Invalid SSN";
        }
        System.out.println("Creditscore: " + creditScore);
        List<String> banks = rulebaseService.getBanks(creditScore, loanAmount);
        LoanRequest loanRequest = new LoanRequest(ssn, loanAmount, loanDuration, creditScore);
        List<LoanResponse> loanRespones = contactBanks(banks, loanRequest);

        return aggregate(loanRespones);
    }

    public static void main(String[] argv) throws IOException {
        Object implementor = new LoanBroker();
        String address = "http://localhost:9000/";
        Endpoint.publish(address, implementor);
        Logger.getGlobal().log(Level.INFO, "WebService listening on " + address);
    }

    private List<LoanResponse> contactBanks(List<String> banks, LoanRequest loanRequest) {
        return banks.parallelStream()
                .map(this.banks::get)
                .map(bank -> bank.contact(loanRequest.translateTo(bank.getDataType())))
                .filter(Objects::nonNull)
                .map(this::normalize)
                .collect(Collectors.toList());
    }

    private LoanResponse normalize(String loanResponse) {
        System.out.println("normalizing: " + loanResponse);
        if (loanResponse.startsWith("{")) { // If json
            return gson.fromJson(loanResponse, LoanResponse.class);
        } // not impl yet
        return null;
    }

    private String aggregate(List<LoanResponse> loanResponses) {
        return loanResponses
                .stream()
                .min(Comparator.comparingDouble(LoanResponse::getInterestRate))
                .map(loanResponse -> "The best loan is with a " + loanResponse.getInterestRate() + " interest rate")
                .orElse("No banks wish to loan you money :(");
    }
}
