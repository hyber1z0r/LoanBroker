package dk.jakobgaard.clients.banks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.webservice.bank.LoanResponse;
import dk.jakobgaard.LoanRequest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public abstract class Bank {
    private String dataType;
    public static final int TIMEOUT = 5000;
    private Gson gson;

    public Bank(String dataType) {
        this.dataType = dataType;
        this.gson = new GsonBuilder().create();
    }

    public abstract String contact(String loanRequest);

    public String getDataType() {
        return dataType;
    }

    public LoanRequest fromJSON(String loanRequest) {
        return gson.fromJson(loanRequest, LoanRequest.class);
    }

    public LoanRequest fromXML(String loanReqeust) {
        return null;
    }

    public String toJSON(LoanResponse loanResponse) {
        return gson.toJson(loanResponse);
    }
}
