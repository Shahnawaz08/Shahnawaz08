package array.arrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class P3_2DArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrList=new ArrayList<>();

        //Insert the first row(1d arraylist)
        ArrayList<Integer> row0=new ArrayList<>();
        row0.add(1);
        row0.add(2);
        row0.add(3);
        System.out.println(row0);
        ArrayList<Integer> row1=new ArrayList<>(Arrays.asList(5,6,7,8));
        System.out.println(row1);
        arrList.add(row0);
        arrList.add(row1);
        arrList.get(0).add(8);
        arrList.get(1).set(1,16);
        System.out.println(arrList);
        System.out.println(arrList.get(0).get(0));
        arrList.add(new ArrayList<>(Arrays.asList(10,20,30)));
        System.out.println(arrList);
        for(int rows=0;rows<arrList.size();rows++){
            for(int j=0;j<arrList.get(rows).size();j++){
                System.out.print(arrList.get(rows).get(j)+" ");
            }
            System.out.println();
        }

    }
}
