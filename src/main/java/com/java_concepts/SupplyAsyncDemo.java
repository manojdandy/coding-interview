package com.java_concepts;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SupplyAsyncDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Executor executor = Executors.newFixedThreadPool(10);

       CompletableFuture<List<Integer>> future = CompletableFuture.supplyAsync(() -> {
           System.out.println(Thread.currentThread().getName());
            return Arrays.asList(1,2,3);
        },executor);

       future.get();
    }
}
