package com.java_concepts.employeereminder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CombineCompleteAbleFuture {
    public CompletableFuture<String> getUser() {

        return CompletableFuture.supplyAsync(() ->
        {
            System.out.println("getUser :: " + Thread.currentThread().getName());
            return "Ram";

        });
    }

    public CompletableFuture<String> getProfile(String user) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("getProfile :: " + Thread.currentThread().getName());
            return "Profile Of " + user;
        });
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CombineCompleteAbleFuture completeAbleFuture = new CombineCompleteAbleFuture();
        CompletableFuture<String> completableFuture = completeAbleFuture.getUser().
                thenCompose(u -> completeAbleFuture.getProfile(u));

        String profile = completableFuture.get();
        System.out.println(profile);


    }
}
