package org.example.excurtorService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo1 {
    public static void main(String[] args) {
        // 创建线程池对象
        // 1. 使用线程池实现类 ThreadPoolExecutor 来创建线程池对象
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        // 2. 使用线程池处理任务
        Runnable task = new MyRunnable(); // Runnale 可以复用
        pool.execute(task); // 提交第一个任务，创建线程并自动启动
        pool.execute(task);
        pool.execute(task);
    }
}