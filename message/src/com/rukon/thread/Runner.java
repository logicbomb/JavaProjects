package com.rukon.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private static String a[] = {"a", "b", "c", "d"};
    private int counter = 0;
    private ReentrantLock r = new ReentrantLock();
    public void AddtoList() throws InterruptedException{

        while(true){
            r.lock();
            try {
                for(int i = 0; i < a.length; i++) {

                    System.out.println("Adding " + a[i]);
                    r.unlock();
                }
            }
            finally {
                r.unlock();
            }



        }

    }

    public void removeFromList() throws InterruptedException {
        Thread.sleep(2000);
        while(true){
r.lock();
try {

    for(int i = 0; i < a.length; i++) {
        r.lock();
        System.out.println("Removing " + a[i]);
        r.unlock();
    }
}
finally {
    r.unlock();
}
        }

    }


}
