package llds.hr_system;


import llds.hr_system.models.Employee;

public class SecurityAPI {
    public void updateAccess(int userId,String status) {
        System.out.println("The Security has Access updated for ::  " + userId + " to ::" + status);
    }
}
