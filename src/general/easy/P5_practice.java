package general.easy;

import java.util.*;

public class P5_practice {
    public static void main(String[] args) {
        int [] number={1,3,5,6,7,8,9,10,11};
        System.out.println(Arrays.binarySearch(number,4));
        System.out.println("==============");
        List<String> list1 = new LinkedList<>();

        list1.add("Scaler");

        list1.add("For");

        list1.add("Coders");

        list1.add("InterviewBit");

        list1.add("Coders");
        List<String> list2 = new LinkedList<>();


        list2.add("Coders");



        list1.removeAll(list2);



        for (String temp : list1)

            System.out.printf(temp + " ");



        System.out.println();
        List<String> list = new LinkedList<>();

        list.add("Scaler");

        list.add("For");

        list.add("Coders");

        list.add("InterviewBit");

        Iterator<String> iter = list.iterator();



        while (iter.hasNext())

            System.out.printf(iter.next() + " ");



        System.out.println("=================================");

        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(3);
        arr.add(4);
        arr.add(7);
        arr.add(5);
        arr.add(9);
        System.out.println(arr.remove(0));

    }
}
