package com.rukon.pc;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("1213"));
    }
}
class Food {
    private String name;
    private int cal;
   private boolean empty = true;
   private ReentrantLock lock;



    public String Read()  {


    return name;//"Consumed " + this.name + " calory: " + this.cal;


   }



    public void Eat(String name, int cal) {
if(!empty) {

    this.name = name;
    this.cal = cal;
}
    }




}

class Produce implements Runnable {
    private Food f;
    private ReentrantLock lock;
    public Produce(Food f) {
        this.f = f;

    }

    @Override
    public void run() {


            for (int i = 0; i < 10; i++) {


                    f.Eat("Buger " + i , 300);
                    System.out.println("Producing Burger: " + i + " calory 300");




                try {
                    Thread.sleep(500);} catch (InterruptedException e){}

            }
           // f.Eat("Finished", 300);


    }
}

class Consume implements Runnable{
    private Food f;

    public Consume(Food f) {
        this.f = f;

    }

    @Override
    public void run() {

            for(int i = 0; i<10; i++){




                        System.out.println("Consuming: " +f.Read());
                        try {
                            Thread.sleep(1000);} catch (InterruptedException e){}






//
//                System.out.println("Not consuming");


        }
    }
}
