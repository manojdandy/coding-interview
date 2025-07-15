package llds.hr_system;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {
    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
    public void send(int userId) {
        queue.add(userId);
    }
    public int receive() throws InterruptedException {
        return queue.take();// blcoking
    }
}
