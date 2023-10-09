package JavaThread;

public class P1_client {
    public static void main(String[] args) {
        P1_HelloWorldPrinter hwpTask=new P1_HelloWorldPrinter();
        System.out.println("Hello from main "+Thread.currentThread().getName());
        Thread t=new Thread(hwpTask);
        t.start();//thread would be created
        System.out.println("Hello from main1 "+Thread.currentThread().getName());
        System.out.println("Hello from main2 "+Thread.currentThread().getName());
        System.out.println("Hello from main3 "+Thread.currentThread().getName());
        System.out.println("Hello from main4 "+Thread.currentThread().getName());
        System.out.println("Hello from main5 "+Thread.currentThread().getName());

    }
}
