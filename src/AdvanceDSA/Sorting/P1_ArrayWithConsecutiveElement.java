package AdvanceDSA.Sorting;

import java.util.Arrays;
import java.util.Scanner;
/*
Given an array of positive integers A, check and return whether the array elements are consecutive or not.
NOTE: Try this with O(1) extra space.
Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
 */

public class P1_ArrayWithConsecutiveElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int isconse=solve(A);
        System.out.println(isconse);

    }
    public static int solve(int[] A) {
        Arrays.sort(A);
        for(int i=0;i<A.length-1;i++){
            if(A[i+1]!=A[i]+1){
                return 0;
            }
        }
        return 1;
    }
}
