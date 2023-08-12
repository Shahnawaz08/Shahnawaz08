package array.arrayList;

import java.util.ArrayList;

public class P1_ArrayListBasic {
    public static void main(String[] args) {
        ArrayList<Integer> arr =new ArrayList<>(5);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(arr);
        arr.add(1,20);
        System.out.println(arr);
        System.out.println(arr.size());
        arr.add(0);
        System.out.println(arr.size());
        System.out.println(arr.get(1));
        arr.set(1,24);
        System.out.println(arr);
        arr.remove(1);
        arr.add(2);
        System.out.println(arr);
        Integer x=2;
        arr.remove(x);
        Integer y=6;
        arr.remove(y);
        System.out.println(arr);
        if(arr.contains(2 )){
            System.out.println("Found");
        }

    }
}
