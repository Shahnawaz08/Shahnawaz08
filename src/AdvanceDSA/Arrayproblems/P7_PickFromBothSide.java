package AdvanceDSA.Arrayproblems;
/*
You are given an integer array A of size N.
You have to pick B elements in total. Some (possibly 0) elements from
left end of array A and some (possibly 0) from the right end of array A to get the maximum sum.
Find and return this maximum possible sum.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P7_PickFromBothSide {
    public static int solve(int[] A, int B) {
        int N= A.length;
        int [] Lps=new int[N+1];
        int [] Rps=new int[N+1];
        Lps[0]=0;
        Rps[0]=0;
        for(int i=0;i<N;i++){
            Lps[i+1]=A[i]+Lps[i];
            Rps[i+1]=A[N-1-i]+Rps[i];
        }
        System.out.println(Arrays.toString(Lps));
        System.out.println(Arrays.toString(Rps));
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<=B;i++){
            int sum=0;
            sum=Lps[i]+Rps[B-i];
            if(sum>maxsum){
                maxsum=sum;
            }
        }
        return maxsum;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("no of elements");
        int B=sc.nextInt();
        int maxsum=solve(arr,B);
        System.out.println(maxsum);
    }
}
