//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package rulebase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "getBanksResponse",
        namespace = "http://rulebase/",
        propOrder = {"_return"}
)
public class GetBanksResponse {
    @XmlElement(
            name = "return"
    )
    protected String _return;

    public GetBanksResponse() {
    }

    public String getReturn() {
        return this._return;
    }

    public void setReturn(String var1) {
        this._return = var1;
    }
}
