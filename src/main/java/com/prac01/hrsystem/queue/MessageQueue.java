package com.prac01.hrsystem.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {
    private final BlockingQueue<Integer> queue;
    private final int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedBlockingQueue<>(capacity);
    }

    public void sent(int userId) {
        queue.add(userId);
    }

    public int receive() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
