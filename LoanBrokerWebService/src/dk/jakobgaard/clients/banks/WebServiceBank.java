package dk.jakobgaard.clients.banks;


import com.webservice.bank.BankService;
import com.webservice.bank.LoanResponse;
import dk.jakobgaard.LoanRequest;

public class WebServiceBank extends Bank {
    private com.webservice.bank.Bank port;

    public WebServiceBank(String dataType) {
        super(dataType);
        this.port = new BankService().getBankPort();
    }

    @Override
    public String contact(String loanRequest) {
        // Parse loanRequest to obj
        System.out.println("Sending ws message: " + loanRequest);
        LoanRequest request = fromJSON(loanRequest);

        LoanResponse loanResponse = this.port.fileLoanRequest(request.getSsn(), request.getCreditScore(),
                request.getLoanAmount(),
                request.getDuration());
        // Parse back to JSON String
        System.out.println("Got this response: " + toJSON(loanResponse));
        return toJSON(loanResponse);
    }
}
