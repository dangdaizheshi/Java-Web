package org.example.lock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private double money;
    private String cardId;
    private final Lock lk = new ReentrantLock();
    public void drawMoney(double money) {
        String name = Thread.currentThread().getName();
        lk.lock();
        try {
            if(money <= this.money) {
                System.out.println(name + "取钱成功，取钱金额：" + money);
                this.money -= money;
                System.out.println("余额为：" + this.money);
            }
            else {
                System.out.println(name + "取钱失败，余额不足");
            }
        } finally {
            lk.unlock();
        }
    }
}