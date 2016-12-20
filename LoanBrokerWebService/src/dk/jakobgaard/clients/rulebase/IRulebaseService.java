package dk.jakobgaard.clients.rulebase;

import java.util.List;

public interface IRulebaseService {
    List<String> getBanks(int creditScore, double loanAmount);
}
