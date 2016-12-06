//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package rulebase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "getBanks",
        namespace = "http://rulebase/",
        propOrder = {"arg0", "arg1"}
)
public class GetBanks {
    protected int arg0;
    protected double arg1;

    public GetBanks() {
    }

    public int getArg0() {
        return this.arg0;
    }

    public void setArg0(int var1) {
        this.arg0 = var1;
    }

    public double getArg1() {
        return this.arg1;
    }

    public void setArg1(double var1) {
        this.arg1 = var1;
    }
}
