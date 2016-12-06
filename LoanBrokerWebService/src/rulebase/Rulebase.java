//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package rulebase;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import rulebase.ObjectFactory;

@WebService(
        name = "Rulebase",
        targetNamespace = "http://rulebase/"
)
@XmlSeeAlso({ObjectFactory.class})
public interface Rulebase {
    @WebMethod
    @WebResult(
            targetNamespace = ""
    )
    @RequestWrapper(
            localName = "getBanks",
            targetNamespace = "http://rulebase/",
            className = "rulebase.GetBanks"
    )
    @ResponseWrapper(
            localName = "getBanksResponse",
            targetNamespace = "http://rulebase/",
            className = "rulebase.GetBanksResponse"
    )
    @Action(
            input = "http://rulebase/Rulebase/getBanksRequest",
            output = "http://rulebase/Rulebase/getBanksResponse"
    )
    String getBanks(@WebParam(name = "arg0",targetNamespace = "") int var1, @WebParam(name = "arg1",targetNamespace = "") double var2);
}
