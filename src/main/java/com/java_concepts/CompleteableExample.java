package com.java_concepts;

import java.util.Arrays;
import java.util.*;
import java.util.concurrent.*;

public class CompleteableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
       Future<List<Integer>> future =  service.submit(() -> {
           System.out.println(Thread.currentThread().getName());
           delay(1);
            return Arrays.asList(1,2,5,10);
        });
        List list = future.get();
        System.out.println(list);
    }
    private static void delay(int min) {
        try {
            TimeUnit.MINUTES.sleep(min);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
