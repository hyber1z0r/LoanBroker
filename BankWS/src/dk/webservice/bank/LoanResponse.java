package dk.webservice.bank;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoanResponse")
public class LoanResponse {
    @XmlElement(name = "interestRate")
    private double interestRate;
    @XmlElement(name = "ssn")
    private String ssn;

    LoanResponse(double interestRate, String ssn) {
        this.interestRate = interestRate;
        this.ssn = ssn;
    }

    public LoanResponse() {
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getSsn() {
        return ssn;
    }
}
