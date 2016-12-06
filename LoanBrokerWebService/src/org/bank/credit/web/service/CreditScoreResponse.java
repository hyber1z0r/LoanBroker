//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bank.credit.web.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "creditScoreResponse",
        namespace = "http://service.web.credit.bank.org/",
        propOrder = {"_return"}
)
public class CreditScoreResponse {
    @XmlElement(
            name = "return"
    )
    protected int _return;

    public CreditScoreResponse() {
    }

    public int getReturn() {
        return this._return;
    }

    public void setReturn(int var1) {
        this._return = var1;
    }
}
