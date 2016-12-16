package dk.jakobgaard;

public class LoanRequest {
    private String ssn;
    private double loanAmount;
    private long duration;
    private int creditScore;

    public LoanRequest(String ssn, double loanAmount, long duration, int creditScore) {
        this.ssn = ssn;
        this.loanAmount = loanAmount;
        this.duration = duration;
        this.creditScore = creditScore;
    }

    public String getSsn() {
        return ssn;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public long getDuration() {
        return duration;
    }

    public int getCreditScore() {
        return creditScore;
    }

    /**
     * CAUTION! Very quick and ugly, instead of finding serialization libraries
     * Don't ever do this again!!!!
     */
    public String translateTo(String dataType) {
        if (dataType.equals("JSON")) {
            return ("{\"ssn\":${ssn},\"creditScore\":${cs},\"loanAmount\":${amount},\"loanDuration\":${dur}}")
                    .replace("${ssn}", this.ssn)
                    .replace("${cs}", this.creditScore + "")
                    .replace("${amount}", this.loanAmount + "")
                    .replace("${dur}", this.duration + "");
        } else if (dataType.equals("XML")) {
            return ("<LoanRequest>" +
                    "<ssn>${ssn}</ssn>" +
                    "<creditScore>${cs}</creditScore>" +
                    "<loanAmount>${amount}</loanAmount>" +
                    "<loanDuration>${dur}</loanDuration>" +
                    "</LoanRequest>")
                            .replace("${ssn}", this.ssn)
                            .replace("${cs}", this.creditScore + "")
                            .replace("${amount}", this.loanAmount + "")
                            .replace("${dur}", "1976-01-01 01:00:00.0 CET");
        }
        return null;
    }
}
