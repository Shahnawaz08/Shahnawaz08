package AdvanceDSA.HeapProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
Given an integer array A of size N.

You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.

Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.


Problem Constraints
1 <= N <= 105
0 <= A[i] <= 103
 */

public class P2_ProductOf3 {

    public static int [] solve(int[] A) {
        int [] B=new int[A.length];
       // MaxHeap mh=new MaxHeap(A.length);
        PriorityQueue<Integer> mh=new PriorityQueue<>(new CustomComp());
        for(int i=0;i<A.length;i++){
            mh.add(A[i]);
            //System.out.println(Arrays.toString(mh.arr));
            if(i<2){
                B[i]=-1;

            }
            else {
                int fst= mh.poll();
                int sec= mh.poll();
                int third=mh.poll();
                mh.add(fst);
                mh.add(sec);
                mh.add(third);
                //System.out.println(fst+" "+sec+" "+third);
                B[i]=fst*sec*third;
            }
        }
        return B;
    }
    static class  CustomComp implements Comparator<Integer>{
        public int compare(Integer a,Integer b){
            return b-a;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int [] maxheap=solve(A);
        System.out.println(Arrays.toString(maxheap));
    }
}
