package llds.stripe.notification;
import java.util.*;

public class SchedulerApp {
    public static void main(String[] args) {
        Map<String, NotificationTemplate> schedule = new HashMap<>();
        schedule.put("start", NotificationTemplate.WELCOME);
        schedule.put("-15", NotificationTemplate.REMINDER);
        schedule.put("end", NotificationTemplate.EXPIRY);

        List<UserAccount> users = new ArrayList<>();
        users.add(new UserAccount(0, 30, "John", "Silver"));
        users.add(new UserAccount(1, 15, "Alice", "Gold"));


        Notifier notifier = new Notifier(schedule);
        notifier.sendEmails(users);
    }
}