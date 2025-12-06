package org.example.TheadSecurity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrawThread extends Thread{
    private Account acc;
    public DrawThread(String name, Account acc) {
        super(name);
        this.acc = acc;
    }
    @Override
    public void run() {
        acc.drawMoney(10000);
    }
}
