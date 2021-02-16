package com.rukon.starvation;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static Object lock = new Object();
    private static ReentrantLock l1 = new ReentrantLock(true);
    public static void main(String[] args) {
        Thread  t1 = new Thread(new Worker(TheadColor.ANSI_RED ), "Priority 10");
        Thread  t2 = new Thread(new Worker(TheadColor.ANSI_BLUE ), "Priority 9");
        Thread  t3 = new Thread(new Worker(TheadColor.ANSI_GREEN ), "Priority 8");
        Thread  t4 = new Thread(new Worker(TheadColor.ANSI_CYAN ), "Priority 6");
        Thread  t5 = new Thread(new Worker(TheadColor.ANSI_PURPLE ), "Priority 2");

        t1.setPriority(10);
        t2.setPriority(9);
        t3.setPriority(8);
        t4.setPriority(6);
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

    private static class Worker implements Runnable{
        private ReentrantLock lock1 = new ReentrantLock();
        private  int runCount =1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {

            for(int i =0; i <100; i ++){
                l1.lock();
                try {
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);

                }
finally {
                    l1.unlock();
                }



            }


        }
    }
}
