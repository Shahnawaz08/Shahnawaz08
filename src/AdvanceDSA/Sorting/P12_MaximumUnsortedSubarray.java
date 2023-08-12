package AdvanceDSA.Sorting;
/*
Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.

Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000000
 */

import java.util.Arrays;
import java.util.Scanner;

public class P12_MaximumUnsortedSubarray {
    /*
    public static int[] subUnsort(int[] A) {
        int s=-1;
        int e=-1;
        for(int i=0;i<A.length-1;i++){
            if(A[i]>A[i+1]){
                if(s==-1){
                    s=i;
                    int index=i;
                    i++;
                    while(i<A.length&&A[index]>A[i]){
                        i++;
                    }
                    i--;
                    e=i;


                }
                else {
                    int index=i;
                    i++;
                    while(i<A.length&&A[index]>A[i]){
                        i++;
                    }
                    i--;
                    e=i;

                }
            }

        }
        if(s==-1){
            int [] arr={s};
            return arr;
        }
        int [] arr={s,e};
        return arr;
    }

     */
    public static int[] subUnsort(int[] A) {
        if(A.length==1){
            int [] arr={-1};
            return arr;
        }
        int [] B=A.clone();
        Arrays.sort(B);
        int s=-1;
        int e=-1;
        for(int i=0;i<A.length;i++){
            if(A[i]!=B[i]){
                if(s==-1){
                    s=i;
                    e=i;
                }
                e=i;
            }
        }
        if(s==-1){
            int [] arr={-1};
            return arr;
        }
        int [] arr={s,e};

        //System.out.println(Arrays.toString(B));
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int []minarray=subUnsort(A);
        System.out.println(Arrays.toString(minarray));
    }
}
