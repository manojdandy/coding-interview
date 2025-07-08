package llds.splitwise.models;

import java.util.HashMap;
import java.util.Map;

public class BalanceMap {
    private final Map<String,Amount> balance;

    public BalanceMap() {
        this.balance = new HashMap<>();
    }

    public BalanceMap(Map<String, Amount> balance) {
        this.balance = balance;
    }

    public Map<String, Amount> getBalance() {
        return balance;
    }
}
