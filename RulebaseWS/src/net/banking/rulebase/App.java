package net.banking.rulebase;

import javax.xml.ws.Endpoint;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] argv) {
        Object implementor = new Rulebase();
        String address = "http://localhost:9001/Rulebase";
        Endpoint.publish(address, implementor);
        Logger.getGlobal().log(Level.INFO, "WebService listening on " + address);
    }
}
