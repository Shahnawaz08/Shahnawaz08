package JavaThread.mergesort;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception {

        System.out.println("Main thread name is: " + Thread.currentThread().getName());
        List<Integer> arrayToSort = List.of(
                10, 2, 8, 11, 4, 3, 9, 1
        );
        Sorter s=new Sorter(arrayToSort);
        List<Integer> sortedList = s.call();

        for (Integer in : sortedList) {
            System.out.println(in);
        }

    }
}
