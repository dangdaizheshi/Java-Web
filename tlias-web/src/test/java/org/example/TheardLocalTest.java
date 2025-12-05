package org.example;

public class TheardLocalTest {
    private static ThreadLocal<String> local = new ThreadLocal<>();
    public static void main(String[] args) {
        local.set("Main message");
        // 创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": " + local.get());
            }
        }).start();
        System.out.println(Thread.currentThread().getName() + ": " + local.get());
        local.remove();
    }
}
