package org.example;

public class TheardTest {
    public static void main(String[] args) {
        // 创建线程对象，代表线程
        MyThread t1 = new MyThread();

        MyRunnable myRunnable = new MyRunnable();
        // 将 runnable 线程任务对象交给 Thread 线程对象
        Thread t2 = new Thread(myRunnable);
        // 启动线程
        t1.start(); // 子线程启动要在主线程之前
        t2.start();
        for (int i = 0; i < 10; i++) System.out.println("主线程输出：" + i);
    }
}
// 定义一个子类继承 Thread 类, 成为一个线程类
class MyThread extends Thread {
    // 重写 Theard 类的 run 方法
    @Override
    public void run() {
        // 在 run 方法中编写要执行的任务
        for (int i = 0; i < 10; i++) System.out.println("子线程输出：" + i);
    }
}

// 线程创建方式 2：实现 Runnable 接口
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) System.out.println("子线程222输出：" + i);
    }
}