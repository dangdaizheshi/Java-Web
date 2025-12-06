package org.example.lock;

public class ThreadSecurtyDemoTest {
    public static void main(String[] args) {
        Account acc = new Account(10000, "1001");
        Thread t1 = new DrawThread("小明",  acc);
        Thread t2 = new DrawThread("小王",  acc);
        t1.start();
        t2.start();
    }
}