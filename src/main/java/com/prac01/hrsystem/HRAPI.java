package com.prac01.hrsystem;

import com.prac01.hrsystem.models.Employee;

public class HRAPI {

    public Employee getEmp(int userId) {
        String status = userId%2 == 0 ? "active":"inactive";
        return new Employee(userId,status);
    }
}
