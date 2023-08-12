package array.IntermidiateArrays;
/*
On the first row, we write a 0. Now in every subsequent row,
we look at the previous row and replace each occurrence of 0 with 01,
and each occurrence of 1 with 10.
Given row number A and index B, return the Bth indexed symbol in row A.
(The values of B are 1-indexed.).
 */

import java.util.ArrayList;
import java.util.Scanner;

public class P32_Kthindexelement {
    public static void main(String[] args) {
        ArrayList <Integer> A=new ArrayList<>();
        A.add(0);
        A.add(1);
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int B=sc.nextInt();
        for(int i=1;i<N;i++) {

            int l = A.size();
            ArrayList<Integer> arr = new ArrayList<>();
            int index = 0;
            for (int j = 0; j < l; j++) {

                int emt = A.get(j);
                if (emt == 0) {
                    arr.add(index++, 0);
                    arr.add(index++, 1);
                }
                if (emt == 1) {
                    arr.add(index++, 1);
                    arr.add(index, 0);
                    index++;
                }

            }
            A = arr;
        }
        System.out.println(A);
        System.out.println(A.get(B-1));
//        System.out.println(A);
//        System.out.println(B);
//        A=B;
//        System.out.println(A);
    }
}
