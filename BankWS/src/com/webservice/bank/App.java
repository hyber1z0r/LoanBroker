package com.webservice.bank;

import javax.xml.ws.Endpoint;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] argv) {
        Object implementor = new Bank();
        String address = "http://localhost:9002/Bank";
        Endpoint.publish(address, implementor);
        Logger.getGlobal().log(Level.INFO, "WebService listening on " + address);
    }
}
