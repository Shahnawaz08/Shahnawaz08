package JavaThread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class P2_ExecutorThread {
    public static void main(String[] args) {
        ExecutorService es= Executors.newFixedThreadPool(50);
        for(int i=0;i<200;i++){
            if(i==16){
                System.out.println(" Task is "+i);
            }
            P2_HelloWorldPrinter task =new P2_HelloWorldPrinter(1);
            es.submit(task);

        }
    }
}
