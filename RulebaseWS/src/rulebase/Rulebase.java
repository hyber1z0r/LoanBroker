package rulebase;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class Rulebase {

    @WebMethod
    public String getBanks(int creditscore, double loanAmount) {
        if (creditscore > 400) {
            return "Leon Bank";
        } else {
            return "Skal Bank";
        }
    }

}
