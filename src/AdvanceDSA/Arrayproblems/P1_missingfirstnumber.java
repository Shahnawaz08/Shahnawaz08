package AdvanceDSA.Arrayproblems;

import java.util.Arrays;
import java.util.Scanner;
/*
Given an unsorted integer array, A of size N. Find the first missing positive integer.

        Note: Your algorithm should run in O(n) time and use constant space.

 */

public class P1_missingfirstnumber {
    public static int firstMissingPositive(int[] A) {
        int N=A.length;
        for(int i=0;i<N;i++){
            if(A[i]<=0){
                A[i]=1000000000;
                System.out.println(A[i]);
            }
        }
        System.out.println(Arrays.toString(A));
        for(int i=0;i<N;i++){
            //System.out.println(Math.abs(A[i]));
            if(Math.abs(A[i])<=N){
                if(A[Math.abs(A[i])-1]>0) {
                    System.out.print(Math.abs(A[i])+" ");

                    A[Math.abs(A[i]) - 1] = -1 * A[Math.abs(A[i]) - 1];

                }
            }

        }
        System.out.println(Arrays.toString(A));
        for(int i=0;i<N;i++){
            if(A[i]>0){
                return i+1;
            }
        }

        return N+1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int missemt=firstMissingPositive(arr);
        System.out.println(missemt);
    }
}
