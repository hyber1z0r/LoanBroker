//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bank.credit.web.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.bank.credit.web.service.CreditScore;
import org.bank.credit.web.service.CreditScoreResponse;

@XmlRegistry
public class ObjectFactory {
    private static final QName _CreditScore_QNAME = new QName("http://service.web.credit.bank.org/", "creditScore");
    private static final QName _CreditScoreResponse_QNAME = new QName("http://service.web.credit.bank.org/", "creditScoreResponse");

    public ObjectFactory() {
    }

    public CreditScore createCreditScore() {
        return new CreditScore();
    }

    public CreditScoreResponse createCreditScoreResponse() {
        return new CreditScoreResponse();
    }

    @XmlElementDecl(
            namespace = "http://service.web.credit.bank.org/",
            name = "creditScore"
    )
    public JAXBElement<CreditScore> createCreditScore(CreditScore var1) {
        return new JAXBElement(_CreditScore_QNAME, CreditScore.class, (Class)null, var1);
    }

    @XmlElementDecl(
            namespace = "http://service.web.credit.bank.org/",
            name = "creditScoreResponse"
    )
    public JAXBElement<CreditScoreResponse> createCreditScoreResponse(CreditScoreResponse var1) {
        return new JAXBElement(_CreditScoreResponse_QNAME, CreditScoreResponse.class, (Class)null, var1);
    }
}
