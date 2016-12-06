//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package rulebase;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import rulebase.GetBanks;
import rulebase.GetBanksResponse;

@XmlRegistry
public class ObjectFactory {
    private static final QName _GetBanksResponse_QNAME = new QName("http://rulebase/", "getBanksResponse");
    private static final QName _GetBanks_QNAME = new QName("http://rulebase/", "getBanks");

    public ObjectFactory() {
    }

    public GetBanks createGetBanks() {
        return new GetBanks();
    }

    public GetBanksResponse createGetBanksResponse() {
        return new GetBanksResponse();
    }

    @XmlElementDecl(
            namespace = "http://rulebase/",
            name = "getBanksResponse"
    )
    public JAXBElement<GetBanksResponse> createGetBanksResponse(GetBanksResponse var1) {
        return new JAXBElement(_GetBanksResponse_QNAME, GetBanksResponse.class, (Class)null, var1);
    }

    @XmlElementDecl(
            namespace = "http://rulebase/",
            name = "getBanks"
    )
    public JAXBElement<GetBanks> createGetBanks(GetBanks var1) {
        return new JAXBElement(_GetBanks_QNAME, GetBanks.class, (Class)null, var1);
    }
}
