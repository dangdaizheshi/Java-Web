package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        // 多线程创建方式3：实现 Callable 接口
        MyCallable c1 = new MyCallable(100);
        // 把 Callbale 对象封装成一个真正的线程任务 FutureTask 对象
        FutureTask<String> ft = new FutureTask<>(c1);
        // 创建线程对象，将 FutureTask 对象交给 Thread 线程对象
        Thread t1 = new Thread(ft);
        t1.start();

        MyCallable c2 = new MyCallable(50);
        FutureTask<String> f2 = new FutureTask<>(c2);
        Thread t2 = new Thread(f2);
        t2.start();

        // 获取线程任务执行结果
        try {
            System.out.println(ft.get());
        } catch (Exception e){
            e.printStackTrace();
        }
        try {
            System.out.println(f2.get());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

// 定义一个实现类实现 Callable 接口
class MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n) {
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return "1-" + n + "的偶数和为：" + sum;
    }
}