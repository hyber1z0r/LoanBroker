package dk.jakobgaard.clients.rulebase;

import net.banking.rulebase.Rulebase;
import net.banking.rulebase.RulebaseService;

import java.util.List;

public class RulebaseServiceHandler {
    private Rulebase port;

    public RulebaseServiceHandler() {
        RulebaseService service = new RulebaseService();
        this.port = service.getRulebasePort();
    }

    /**
     * @param creditScore The creditscore of the person
     * @param loanAmount  The amount the person wants to lend
     * @return banks The banks to contact in a list
     */
    public List<String> getBanks(int creditScore, double loanAmount) {
        return port.getBanks(creditScore, loanAmount);
    }
}
