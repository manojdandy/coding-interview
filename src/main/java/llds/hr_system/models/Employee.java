package llds.hr_system.models;

public class Employee {
    private final int userId;
    private final String status;

    public Employee(int userId, String status) {
        this.userId = userId;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }
}
