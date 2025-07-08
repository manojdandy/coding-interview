package llds.splitwise.models;

public class Amount {
    private final Double amount;
    private final String currency;

    public Amount(Double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
   public Amount add(Double amount) {
        return new Amount(amount + amount,"INR");
   }

    public Double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
