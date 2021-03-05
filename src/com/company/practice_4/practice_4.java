package com.company.practice_4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class practice_4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new NewExecutorService(3);
        Future<String> future = executorService.submit(() -> "Start!");
        executorService.submit(() -> {
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("We run it!");
        });
        executorService.shutdown();
        System.out.println(future.isDone() ? future.get() : null);
    }
}
