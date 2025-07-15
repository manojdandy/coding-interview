package llds.hr_system.completeablefuture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        int capacity = 5;
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);
        //producer
        new Thread(() -> {
            while (true) {
                for(int i = 0; i< 20;i++) {
                    try {
                        System.out.println("publishing :: "+ i);
                        queue.put(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
        //consumer
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("consumer thread ::" + Thread.currentThread().getName());
                    System.out.println("consuming ::"+ queue.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
