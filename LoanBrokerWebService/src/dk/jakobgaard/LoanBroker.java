package dk.jakobgaard;

import dk.jakobgaard.clients.rulebase.RulebaseServiceHandler;
import dk.jakobgaard.clients.credit.CreditServiceHandler;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService()
public class LoanBroker {
    private CreditServiceHandler creditServiceHandler;
    private RulebaseServiceHandler rulebaseServiceHandler;

    public LoanBroker() {
        this.creditServiceHandler = new CreditServiceHandler();
        this.rulebaseServiceHandler = new RulebaseServiceHandler();
    }

    @WebMethod
    public String fileLoanRequest(String ssn, double loanAmount, long loanDuration) {
        int creditScore = creditServiceHandler.getCreditScore(ssn);
        if (creditScore < 0) {
            return "Invalid SSN";
        }

        String banks = rulebaseServiceHandler.getBanks(creditScore, loanAmount);
        System.out.println("Got this bank" + banks);

        return "You a nigga";
    }

    public static void main(String[] argv) {
        Object implementor = new LoanBroker();
        String address = "http://localhost:9000/";
        Endpoint.publish(address, implementor);
        System.err.println("WebService listening on " + address);
    }
}
