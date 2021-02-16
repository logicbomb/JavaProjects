package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
      //  countdown = new Countdown();
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        if(t1.isAlive()) {
            System.out.println("t1 is alive" + t1.getId());
            t1.getId();
        }
        t2.start();
	// write your code here
    }


}

class Countdown {
    private int i;
    public void docountDown(){
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color= ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_RED;

        }
synchronized (this){
        for (i= 10; i > 0; i--){
            System.out.println(color + Thread.currentThread().getName() + ": i=" + i);
        }
    }}
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;
    public CountdownThread(Countdown countdown){
        threadCountdown = countdown;
    }
    public void run(){
threadCountdown.docountDown();
    }

}
