//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bank.credit.web.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;
import org.bank.credit.web.service.CreditScoreService;

@WebServiceClient(
        name = "CreditScoreService",
        targetNamespace = "http://service.web.credit.bank.org/",
        wsdlLocation = "http://139.59.154.97:8080/CreditScoreService/CreditScoreService?wsdl"
)
public class CreditScoreService_Service extends Service {
    private static final URL CREDITSCORESERVICE_WSDL_LOCATION;
    private static final WebServiceException CREDITSCORESERVICE_EXCEPTION;
    private static final QName CREDITSCORESERVICE_QNAME = new QName("http://service.web.credit.bank.org/", "CreditScoreService");

    public CreditScoreService_Service() {
        super(__getWsdlLocation(), CREDITSCORESERVICE_QNAME);
    }

    public CreditScoreService_Service(WebServiceFeature... var1) {
        super(__getWsdlLocation(), CREDITSCORESERVICE_QNAME, var1);
    }

    public CreditScoreService_Service(URL var1) {
        super(var1, CREDITSCORESERVICE_QNAME);
    }

    public CreditScoreService_Service(URL var1, WebServiceFeature... var2) {
        super(var1, CREDITSCORESERVICE_QNAME, var2);
    }

    public CreditScoreService_Service(URL var1, QName var2) {
        super(var1, var2);
    }

    public CreditScoreService_Service(URL var1, QName var2, WebServiceFeature... var3) {
        super(var1, var2, var3);
    }

    @WebEndpoint(
            name = "CreditScoreServicePort"
    )
    public CreditScoreService getCreditScoreServicePort() {
        return (CreditScoreService)super.getPort(new QName("http://service.web.credit.bank.org/", "CreditScoreServicePort"), CreditScoreService.class);
    }

    @WebEndpoint(
            name = "CreditScoreServicePort"
    )
    public CreditScoreService getCreditScoreServicePort(WebServiceFeature... var1) {
        return (CreditScoreService)super.getPort(new QName("http://service.web.credit.bank.org/", "CreditScoreServicePort"), CreditScoreService.class, var1);
    }

    private static URL __getWsdlLocation() {
        if(CREDITSCORESERVICE_EXCEPTION != null) {
            throw CREDITSCORESERVICE_EXCEPTION;
        } else {
            return CREDITSCORESERVICE_WSDL_LOCATION;
        }
    }

    static {
        URL var0 = null;
        WebServiceException var1 = null;

        try {
            var0 = new URL("http://139.59.154.97:8080/CreditScoreService/CreditScoreService?wsdl");
        } catch (MalformedURLException var3) {
            var1 = new WebServiceException(var3);
        }

        CREDITSCORESERVICE_WSDL_LOCATION = var0;
        CREDITSCORESERVICE_EXCEPTION = var1;
    }
}
