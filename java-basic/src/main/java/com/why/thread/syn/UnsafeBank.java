package com.why.thread.syn;

public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(1000,"基金");
        Drawing you = new Drawing(account,50,"你");
        Drawing me = new Drawing(account,100,"我");
        you.start();
        me.start();
    }
}

class Account{
    int money;//余额
    String name; //卡名

    public Account(int money,String name){
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread{
    Account account;//账户
    int drawingMoney;//取了多少钱
    int nowMoney;//现在手里有多少钱

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {

        synchronized (account) {
            if (account.money - drawingMoney < 0) {
                System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money = account.money - drawingMoney;

            nowMoney = nowMoney + drawingMoney;
            System.out.println(account.name + "余额为：" + account.money);

            System.out.println(this.getName() + "手里的钱" + nowMoney);
        }
    }
}
