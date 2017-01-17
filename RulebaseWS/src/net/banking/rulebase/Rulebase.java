package net.banking.rulebase;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
// WebService using XML via SOAP. Exposes a WSDL document that describes this service
@WebService()
public class Rulebase {

    @WebMethod
    public List<String> getBanks(int creditscore, double loanAmount) {
        List<String> lenders = new ArrayList<>();

        if (creditscore > 725 && loanAmount >= 1000000) {
            lenders.add("Goldmann Sachs");
        }

        if (creditscore > 250 && loanAmount > 50000) {
            lenders.add("Chill Bank");
        }

        //always return Vivus as an option
        lenders.add("Vivus");
        return lenders;
    }
}
