package com.prac01.hrsystem;

import com.prac01.hrsystem.queue.MessageQueue;

import java.util.List;

public class HRSystem {
    private final MessageQueue queue;

    public HRSystem(MessageQueue queue) {
        this.queue = queue;
    }
    public void emitUserIds(List<Integer> userIds) {
        for(int id:userIds) {
            queue.sent(id);
        }
    }

}
