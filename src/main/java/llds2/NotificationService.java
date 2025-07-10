package llds2;

import org.springframework.context.support.StaticMessageSource;

import java.util.ArrayList;
import java.util.List;

/**
 * user_accounts = [
 *     {"account_date": 0, "duration": 30, "name": "John", "plan": "Silver"},
 *     {"account_date": 1, "duration": 15, "name": "Alice", "plan": "Gold"},
 * ]
 */
public class NotificationService {
    public static void main(String[] args) {
        String template = "0: [Welcome] Subscription for John (Silver)";
        ///
        List<User> userAccounts = new ArrayList<>();
        userAccounts.add(new User(0,30,"john","silver","NEW"));
        userAccounts.add(new User(1,15,"Alice","Gold","NEW"));


        //
    }
    //List of messages
    //
    static List<String> getNotificationList(List<User> userAccounts) {
        List<String> msgList = new ArrayList<>();
        for(User user : userAccounts) {
            //calculation WELCOME, EXPIRAY, REMINDER

        }
        return  msgList;
    }

}
