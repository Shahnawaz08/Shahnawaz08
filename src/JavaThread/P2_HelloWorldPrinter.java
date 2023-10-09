package JavaThread;

public class P2_HelloWorldPrinter implements Runnable {
    private int i=0;
    public P2_HelloWorldPrinter(int i){
        this.i=i;
    }

    @Override
    public void run() {
        System.out.println("Hello world "+i+" "+Thread.currentThread().getName());
    }
}
