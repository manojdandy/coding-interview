package llds.stripe.notification;
import java.util.*;
class Notifier {
    private final Map<String, NotificationTemplate> schedule;

    public Notifier(Map<String, NotificationTemplate> schedule) {
        this.schedule = schedule;
    }

    public void sendEmails(List<UserAccount> users) {
        int maxDay = users.stream()
                .mapToInt(u -> u.accountDate + u.duration)
                .max()
                .orElse(0);

        Map<String, Set<NotificationTemplate>> sent = new HashMap<>();
        for (UserAccount u : users) {
            sent.put(u.name, new HashSet<>());
        }

        for (int day = 0; day <= maxDay; day++) {
            System.out.println("\n--- Day " + day + " ---");
            for (UserAccount user : users) {
                int expireDay = user.accountDate + user.duration;

                for (Map.Entry<String, NotificationTemplate> entry : schedule.entrySet()) {
                    int sendDay;
                    if (entry.getKey().equals("start")) {
                        sendDay = user.accountDate;
                    } else if (entry.getKey().equals("end")) {
                        sendDay = expireDay;
                    } else {
                        int offset = Integer.parseInt(entry.getKey()); // e.g., -15
                        sendDay = expireDay + offset;
                    }

                    if (sendDay == day && !sent.get(user.name).contains(entry.getValue())) {
                        sendNotification(user, entry.getValue());
                        sent.get(user.name).add(entry.getValue());
                    }
                }
            }

            boolean allDone = sent.values().stream().allMatch(s -> s.size() == schedule.size());
            if (allDone) {
                System.out.println("\n✅ All notifications sent. Scheduler stopping.");
                break;
            }
        }
    }

    private void sendNotification(UserAccount user, NotificationTemplate template) {
        System.out.printf("To: %s | %s | Plan: %s%n",
                user.name,
                template.getMessage(),
                user.plan);
    }
}