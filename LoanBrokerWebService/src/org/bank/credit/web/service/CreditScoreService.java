//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bank.credit.web.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import org.bank.credit.web.service.ObjectFactory;

@WebService(
        name = "CreditScoreService",
        targetNamespace = "http://service.web.credit.bank.org/"
)
@XmlSeeAlso({ObjectFactory.class})
public interface CreditScoreService {
    @WebMethod
    @WebResult(
            targetNamespace = ""
    )
    @RequestWrapper(
            localName = "creditScore",
            targetNamespace = "http://service.web.credit.bank.org/",
            className = "org.bank.credit.web.service.CreditScore"
    )
    @ResponseWrapper(
            localName = "creditScoreResponse",
            targetNamespace = "http://service.web.credit.bank.org/",
            className = "org.bank.credit.web.service.CreditScoreResponse"
    )
    @Action(
            input = "http://service.web.credit.bank.org/CreditScoreService/creditScoreRequest",
            output = "http://service.web.credit.bank.org/CreditScoreService/creditScoreResponse"
    )
    int creditScore(@WebParam(name = "ssn",targetNamespace = "") String var1);
}
