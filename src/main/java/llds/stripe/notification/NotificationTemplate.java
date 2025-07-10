package llds.stripe.notification;

enum NotificationTemplate {
    WELCOME("Welcome Email"),
    REMINDER("Expiry Reminder Email"),
    EXPIRY("Expired Notification Email");

    private final String message;
    NotificationTemplate(String message) { this.message = message; }
    public String getMessage() { return message; }
}