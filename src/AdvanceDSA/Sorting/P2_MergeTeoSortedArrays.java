package AdvanceDSA.Sorting;

import java.util.Arrays;
import java.util.Scanner;
/*
Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
Problem Constraints
-1010 <= A[i], B[i] <= 1010
 */

public class P2_MergeTeoSortedArrays {
    public static int[] solve(final int[] A, final int[] B) {
        int N=A.length;
        int M=B.length;
        int i=0,j=0;
        int [] sortedArray=new int[N+M];
        int index=0;
        while (i<N||j<M){
            int Aelm,Belm;
            if(i==N){
                Aelm=Integer.MAX_VALUE;
            }
            else{
                Aelm=A[i];
            }
            if(j==M){
                Belm=Integer.MAX_VALUE;
            }
            else{
                Belm=B[j];
            }
            if(Aelm<Belm){
                sortedArray[index]=Aelm;
                index++;
                i++;
            }
            else{
                sortedArray[index]=Belm;
                index++;
                j++;
            }
        }
        return sortedArray;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("2nd array");
        int M=sc.nextInt();
        int [] B=new int[M];
        for(int i=0;i<M;i++){
            B[i]=sc.nextInt();
        }
        int [] sorted=solve(A,B);
        System.out.println(Arrays.toString(sorted));

    }
}
