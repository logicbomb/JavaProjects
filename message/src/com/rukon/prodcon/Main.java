package com.rukon.prodcon;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static com.rukon.prodcon.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ReentrantLock bufferLock = new ReentrantLock();
        List<String> buffer = new ArrayList<String>();
        MyProducer producer = new MyProducer(buffer, TheadColor.ANSI_RED, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, TheadColor.ANSI_BLUE, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, TheadColor.ANSI_GREEN, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

    }
}
class MyProducer implements Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4"};

        for(String num:nums){
            try {
                System.out.println(color + "Adding.." + num);
                    bufferLock.lock();
                    try {
                        buffer.add(num);

                    }
                    finally {
                        bufferLock.unlock();
                    }


                Thread.sleep(random.nextInt(1000));
            }
            catch (InterruptedException e){
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println(color + "Adding EOF and exiting....");
        bufferLock.lock();
try {
    buffer.add("EOF");
}
       finally {
    bufferLock.unlock();
}

    }
}

class MyConsumer implements Runnable{
    private List<String> buffer;
    private String  color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
if(bufferLock.tryLock()){
try {
    if (buffer.isEmpty()) {

        continue;
    }
    System.out.println(color + "The counter " + counter);
    if (buffer.get(0).equals(EOF)) {
        System.out.println("Exiting");

        break;
    } else {
        System.out.println(color + "removed " + buffer.remove(0));
    }
}
  finally {
    bufferLock.unlock();
}
}
else    {
    counter++;
}

        }
    }
}