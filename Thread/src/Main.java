import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(1);

        System.out.println(ANSI_RED + "Hello from the first thread");
        Thread anotherThread = new AnotherThread();
        e.execute(anotherThread);
        int i = 0;
        for(i = 0; i < 10; i++){
            e.execute( new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hellow from: Thread " + Thread.currentThread().getName());
                }
            }));
        }

        System.out.println("Hello again from the first thread");

        e.shutdown();

        try {

        }
        catch (IOException s) {s.getMessage()}
    }
}