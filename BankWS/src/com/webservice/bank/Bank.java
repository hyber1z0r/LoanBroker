package com.webservice.bank;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class Bank {
    @WebMethod
    public LoanResponse fileLoanRequest(String ssn, int creditScore, double loanAmount, long loanDuration) {
        if (creditScore > 500) {
            return new LoanResponse(2.5, ssn);
        }
        return new LoanResponse(4.0, ssn);
    }
}
