package com.rukon.ch1;

import java.io.RandomAccessFile;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        BankAccount bankAccount = new BankAccount("123456", 1000);

       Thread T1=  new Thread(new Runnable() {
            @Override
            public void run() {

             bankAccount.deposit(300);

             bankAccount.withdraw(50);

            }
        });

        Thread T2= new Thread(new Runnable() {
            @Override
            public void run() {

                bankAccount.deposit(203.75);
                bankAccount.withdraw(100);

            }
        });
        T1.start();
        T2.start();
        T1.join();
        T2.join();

        System.out.println("Account balance is: " + bankAccount.getBalance());
    }
}

class BankAccount {

    private double balance;
    private String accountNumber;
    private ReentrantLock lock1;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock1 = new ReentrantLock();

    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        boolean status = false;

        try {
            if (lock1.tryLock(1000, TimeUnit.MILLISECONDS)) {


            try {
                balance += amount;
                status = true;
            } finally {
                lock1.unlock();
            }
        }

            else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Transaction status = " +  status);
    }





    public void withdraw(double amount) {
        boolean status = false;
        try {
            if (lock1.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock1.unlock();
                }
            }

            else {
                System.out.println("Could not get the lock");
            }

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Transaction status = " +  status);

    }
    public String getAccountNumber(){
        return this.accountNumber;
    }

    public void printAccountNumber(){
        System.out.println("Account number = " + this.accountNumber);
    }
}
