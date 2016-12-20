package dk.jakobgaard.clients.credit;


import org.bank.credit.web.service.CreditScoreService;
import org.bank.credit.web.service.CreditScoreService_Service;

public class CreditServiceHandler implements CreditService {
    private CreditScoreService port;

    public CreditServiceHandler() {
        CreditScoreService_Service service = new CreditScoreService_Service();
        this.port = service.getCreditScoreServicePort();
    }

    /**
     * @param ssn Social security number in valid danish format (XXXXXX-XXXX) including the dash.
     * @return creditScore between 0 and 800 if valid ssn, -1 otherwise
     */
    public int getCreditScore(String ssn) {
        return port.creditScore(ssn);
    }
}
