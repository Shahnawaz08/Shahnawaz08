package JavaThread;

public class P1_HelloWorldPrinter implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello world "+Thread.currentThread().getName());
    }
}
