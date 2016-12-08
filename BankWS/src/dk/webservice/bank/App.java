package dk.webservice.bank;

import javax.xml.ws.Endpoint;

public class App {
    public static void main(String[] argv) {
        Object implementor = new Bank();
        String address = "http://localhost:9002/Bank";
        Endpoint.publish(address, implementor);
    }
}
