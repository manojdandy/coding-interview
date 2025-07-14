package com.java_concepts.employeereminder;

import com.java_concepts.Employee;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
//https://github.com/Java-Techie-jt/completablefuture-demo/tree/main
public class EmplyeeService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("**********Employees Service********");
        Executor executor = Executors.newFixedThreadPool(10);

        //read new joinee
       CompletableFuture<Void> completableFuture =  CompletableFuture.supplyAsync(()->{
            System.out.println("fetcing emplyees details :: " + Thread.currentThread().getName());
            List<Employee> employees = EmplyeeDB.findEmployees().stream().
                    filter(emp -> "TRUE".equals(emp.getNewJoiner()) ).collect(Collectors.toList());
            return employees;
        },executor).thenApplyAsync((emps) ->{
            //get emplyees ID
            System.out.println("getting employees emails :: " + Thread.currentThread().getName());
            List<String> empEmails = emps.stream().map(e -> e.getEmail()).collect(Collectors.toList());
            return empEmails;
        }).thenAcceptAsync((emails) -> {
           System.out.println("Sending Emails :: " + Thread.currentThread().getName());
            emails.forEach(EmplyeeService::sendEmail);
        });

        completableFuture.get();

    }
    public static void sendEmail(String empID) {
        System.out.println("sending email to ::" + empID);
    }
}
