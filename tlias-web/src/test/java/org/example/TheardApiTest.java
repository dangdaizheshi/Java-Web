package org.example;

public class TheardApiTest {
    public static void main(String[] args) {
        tThread t1 = new tThread("线程1");
        //t1.setName("线程1");
        t1.start();
        System.out.println(t1.getName());

        tThread t2 = new tThread("线程2");
        //t2.setName("线程2");
        t2.start();
        System.out.println(t2.getName());

        myRunnable r = new myRunnable();
        Thread t3 = new Thread(r, "线程3");
        t3.start();
        System.out.println(t3.getName());

        Thread m = Thread.currentThread();
        System.out.println(m.getName());
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程输出：" + i);
        }
    }
}
 class tThread extends Thread {
    public tThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "线程输出：" + i);
        }
    }
}

class myRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "线程输出：" + i);
        }
    }
}