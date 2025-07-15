package com.prac01.hrsystem;

import com.prac01.hrsystem.models.Employee;
import com.prac01.hrsystem.queue.MessageQueue;

public class WorkerService {
    private HRAPI hrapi;
    private SecurityAPI securityAPI;
    private MessageQueue queue;

    public WorkerService(HRAPI hrapi, SecurityAPI securityAPI, MessageQueue queue) {
        this.hrapi = hrapi;
        this.securityAPI = securityAPI;
        this.queue = queue;
    }

    public void start() {

        while (true) {
            System.out.println("start API ::" + Thread.currentThread().getName());
            int userId = queue.receive();
            Employee emp = hrapi.getEmp(userId);
            securityAPI.updateAccess(userId,emp.getStatus());
        }
    }
}
