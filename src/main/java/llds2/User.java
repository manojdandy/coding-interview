package llds2;

public class User {
    int account_date;
    int duration;
    String name;
    String plan;
    String expire;

    public User(int account_date, int duration, String name, String plan, String expire) {
        this.account_date = account_date;
        this.duration = duration;
        this.name = name;
        this.plan = plan;
        this.expire = expire;
    }
}
