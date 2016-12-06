package rulebase;

import javax.xml.ws.Endpoint;

public class App {
    public static void main(String[] argv) {
        Object implementor = new Rulebase();
        String address = "http://localhost:9001/Rulebase";
        Endpoint.publish(address, implementor);
        System.err.println("WebService listening on " + address);
    }
}
