//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bank.credit.web.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "creditScore",
        namespace = "http://service.web.credit.bank.org/",
        propOrder = {"ssn"}
)
public class CreditScore {
    protected String ssn;

    public CreditScore() {
    }

    public String getSsn() {
        return this.ssn;
    }

    public void setSsn(String var1) {
        this.ssn = var1;
    }
}
