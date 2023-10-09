package JavaThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class P3_ExecutorcachedThread {
    public static void main(String[] args) {
        ExecutorService es= Executors.newCachedThreadPool();
        for(int i=0;i<200;i++){
            if(i==16){
                System.out.println(" Task is "+i);
            }
            P2_HelloWorldPrinter task =new P2_HelloWorldPrinter(1);
            es.submit(task);

        }
    }
}
