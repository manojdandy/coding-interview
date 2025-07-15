package llds.hr_system;

import llds.hr_system.models.Employee;

public class HRAPI {
    public Employee getEmployee(int userId) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String status = (userId%2 == 0) ? "active":"inactive";
        return new Employee(userId,status);
    }
}
