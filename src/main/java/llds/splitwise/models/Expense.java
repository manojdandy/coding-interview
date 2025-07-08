package llds.splitwise.models;

public class Expense {
    private final BalanceMap userBalances;
    private final String title;
    private final String groupId;

    public Expense(BalanceMap userBalances, String title, String groupId) {
        this.userBalances = userBalances;
        this.title = title;
        this.groupId = groupId;
    }

    public BalanceMap getUserBalances() {
        return userBalances;
    }

    public String getGroupId() {
        return groupId;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "userBalances=" + userBalances +
                ", title='" + title + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
