package AdvanceDSA.Sorting;
/*
Given an array A of size N, Groot wants you to pick 2 indices i and j such that

1 <= i, j <= N
A[i] % A[j] is maximum among all possible pairs of (i, j).
Help Groot in finding the maximum value of A[i] % A[j] for some i, j.

Problem Constraints
1 <= N <= 100000
0 <= A[i] <= 100000
 */

import java.util.Arrays;
import java.util.Scanner;

public class P3_MaxMod {
    public static int solve(int[] A) {
        Arrays.sort(A);
        int N=A.length;
        int maxemt=A[N-1];
        int secemt=A[N-1];
        for(int i=N-2;i>=0;i--){
            if(A[i]<maxemt){
                secemt=A[i];
                break;
            }
        }
        return secemt%maxemt;
    }
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
}
