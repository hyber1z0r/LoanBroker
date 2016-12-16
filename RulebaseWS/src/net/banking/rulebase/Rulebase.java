package net.banking.rulebase;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService()
public class Rulebase {

    @WebMethod
    public List<String> getBanks(int creditscore, double loanAmount) {
        List<String> lenders = new ArrayList<>();
        //If creditscore is over 725 and loanamount is rich as f**k, give richkid option
        if (creditscore > 725 && loanAmount >= 1000000) {
            lenders.add("Goldmann Sachs");
        }
        //If credit score is over 350 and loanamout is under rich as f**k, give chill and nice dk.webservice.bank
        if (creditscore > 250 && loanAmount > 50000) {
            lenders.add("Chill Bank");
         //   lenders.add("Vivus");
        }
        //always return Not Safe Bank as an option
        lenders.add("Not Safe Bank");
        return lenders;
    }
}
