//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package rulebase;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;
import rulebase.Rulebase;

@WebServiceClient(
        name = "RulebaseService",
        targetNamespace = "http://rulebase/",
        wsdlLocation = "http://localhost:9001/Rulebase?wsdl"
)
public class RulebaseService extends Service {
    private static final URL RULEBASESERVICE_WSDL_LOCATION;
    private static final WebServiceException RULEBASESERVICE_EXCEPTION;
    private static final QName RULEBASESERVICE_QNAME = new QName("http://rulebase/", "RulebaseService");

    public RulebaseService() {
        super(__getWsdlLocation(), RULEBASESERVICE_QNAME);
    }

    public RulebaseService(WebServiceFeature... var1) {
        super(__getWsdlLocation(), RULEBASESERVICE_QNAME, var1);
    }

    public RulebaseService(URL var1) {
        super(var1, RULEBASESERVICE_QNAME);
    }

    public RulebaseService(URL var1, WebServiceFeature... var2) {
        super(var1, RULEBASESERVICE_QNAME, var2);
    }

    public RulebaseService(URL var1, QName var2) {
        super(var1, var2);
    }

    public RulebaseService(URL var1, QName var2, WebServiceFeature... var3) {
        super(var1, var2, var3);
    }

    @WebEndpoint(
            name = "RulebasePort"
    )
    public Rulebase getRulebasePort() {
        return (Rulebase)super.getPort(new QName("http://rulebase/", "RulebasePort"), Rulebase.class);
    }

    @WebEndpoint(
            name = "RulebasePort"
    )
    public Rulebase getRulebasePort(WebServiceFeature... var1) {
        return (Rulebase)super.getPort(new QName("http://rulebase/", "RulebasePort"), Rulebase.class, var1);
    }

    private static URL __getWsdlLocation() {
        if(RULEBASESERVICE_EXCEPTION != null) {
            throw RULEBASESERVICE_EXCEPTION;
        } else {
            return RULEBASESERVICE_WSDL_LOCATION;
        }
    }

    static {
        URL var0 = null;
        WebServiceException var1 = null;

        try {
            var0 = new URL("http://localhost:9001/Rulebase?wsdl");
        } catch (MalformedURLException var3) {
            var1 = new WebServiceException(var3);
        }

        RULEBASESERVICE_WSDL_LOCATION = var0;
        RULEBASESERVICE_EXCEPTION = var1;
    }
}
