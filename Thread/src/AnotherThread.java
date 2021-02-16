public class AnotherThread extends Thread {
    private static final String ANSI_BLUE = "\u001B[34m";

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hellow from another thread");

    }
}
