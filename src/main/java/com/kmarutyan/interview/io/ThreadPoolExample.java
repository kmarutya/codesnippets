package com.kmarutyan.interview.io;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void concurrentRun() {
        ThreadPoolExecutor executor=null;
        try {
            executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

            for (int i = 1; i <= 5; i++) {
                Task task = new Task("Task " + i);
                System.out.println("Created : " + task.getName());

                executor.execute(task);
            }
        }
        finally{
            executor.shutdown();
        }

    }
    public static void scheduledRun()
    {
        ScheduledThreadPoolExecutor executor =
                (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(2);

        Task task = new Task("Repeat Task");
        System.out.println("Created : " + task.getName());

        executor.scheduleWithFixedDelay(task, 2, 2, TimeUnit.SECONDS);
    }
    public static void main(String[] args)
    {
//        concurrentRun();
        scheduledRun();

    }
}


class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Executing : " + name);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
