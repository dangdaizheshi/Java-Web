package org.example.TheadSecurity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private double money;
    private String cardId;
    public void drawMoney(double money) {
        String name = Thread.currentThread().getName();
        if(money <= this.money) {
            System.out.println(name + "取钱成功，取钱金额：" + money);
            this.money -= money;
            System.out.println("余额为：" + this.money);
        }
        else {
            System.out.println(name + "取钱失败，余额不足");
        }
    }
}
