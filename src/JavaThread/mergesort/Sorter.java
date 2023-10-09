package JavaThread.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Sorter implements Callable <List<Integer>> {
    List<Integer> arrayToSort;
    public Sorter(List<Integer> arrayToSort) {
        this.arrayToSort=arrayToSort;
    }

    @Override
    public List<Integer> call() throws Exception {
        System.out.println("call thread name is: " + Thread.currentThread().getName()
                + " Array IS: " + arrayToSort.toString());
        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }

        int mid = arrayToSort.size()/2;

        // left array
        List<Integer> leftArray = new ArrayList<>();
        for(int i=0; i<mid;++i){
            leftArray.add(arrayToSort.get(i));
        }

        // right array
        List<Integer> rightArray = new ArrayList<>();
        for(int i=mid; i<arrayToSort.size();++i){
            rightArray.add(arrayToSort.get(i));
        }
        Sorter leftsorter=new Sorter(leftArray);
        Sorter rightsorter=new Sorter(rightArray);

        List<Integer> leftSortedArray=leftsorter.call();
        List<Integer> rightSortedArray=rightsorter.call();

        List<Integer> sortedArray = new ArrayList<>();
        int i=0,j=0;

        while(i < leftSortedArray.size() && j < rightSortedArray.size()){
            if(leftSortedArray.get(i) < rightSortedArray.get(j)){
                sortedArray.add(leftSortedArray.get(i));
                ++i;
            }else{
                sortedArray.add(rightSortedArray.get(j));
                ++j;
            }
        }
        // s5 WHAT ELSE? --> check for remaining half
        while(i < leftSortedArray.size()){
            sortedArray.add(leftSortedArray.get(i)); i++;
        }

        while(j < rightSortedArray.size()){
            sortedArray.add(rightSortedArray.get(j)); j++;
        }

        // s6 now return --> LEts go to CLIENT
        return  sortedArray;
    }
}
