package com.prac01.hrsystem;

import com.prac01.hrsystem.queue.MessageQueue;

import java.util.List;

public class SystemController {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(5);
        HRSystem hrSystem = new HRSystem(queue);

        WorkerService service = new WorkerService(new HRAPI(),new SecurityAPI(),queue);
        new Thread(() -> {
            service.start();
        }).start();
        hrSystem.emitUserIds(List.of(1,2,3,4,5,7));
    }
}
