package llds.stripe.notification;

class UserAccount {
    int accountDate;
    int duration;
    String name;
    String plan;

    public UserAccount(int accountDate, int duration, String name, String plan) {
        this.accountDate = accountDate;
        this.duration = duration;
        this.name = name;
        this.plan = plan;
    }
}