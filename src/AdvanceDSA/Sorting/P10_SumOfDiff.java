package AdvanceDSA.Sorting;

import java.util.Arrays;
import java.util.Scanner;

/*
Problem Description
Given an integer array, A of size N.
You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence. Then add up all the differences to get the number.

As the number may be large, output the number modulo 1e9 + 7 (1000000007).

NOTE: Subsequence can be non-contiguous.


Problem Constraints
1 <= N <= 10000
1<= A[i] <=1000
 */
public class P10_SumOfDiff {
    public static int pow(int A, int B, int C) {
        if(A==0){
            return 0;
        }
        if(B==0){
            return 1;
        }
        long tempPow=(long)pow(A,B/2,C);
        long power=(tempPow*tempPow)%C;
        power=(power+C)%C;
        if(B%2==0){
            return (int)power;
        }
        power= (A*power)%C;
        return (int)(power+C)%C;

    }
    //in 0(nlogn)
    public static int solve2(int[] A) {
        long sumofdiff=0;
        long min=0;
        long max=0;
        int len=A.length;
        Arrays.sort(A);
        for(int i=0;i<len;i++){
            int emt=A[i];
            min+=((long)emt*(pow(2,(len-1-i),1000000007))%1000000007);
            max+=((long)emt*(pow(2,i,1000000007)))%1000000007;
            min=min%1000000007;
            max=max%1000000007;

        }

        sumofdiff=(max-min+1000000007)%1000000007;
        return (int)sumofdiff;
    }
    //in 0(n^2)
    public static int solve(int[] A) {
        Arrays.sort(A);
        int N=A.length;
        long sum=0;
        for(int i=0;i<N-1;i++){
            for (int j=i+1;j<N;j++){
                //System.out.println(Math.pow(2,(j-i-1)));
                sum+=((A[j]-A[i])*pow(2,(j-i-1),1000000007))%1000000007;

            }
        }
        return (int)sum;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int minNo=solve(A);
        System.out.println(minNo);
        minNo=solve2(A);
        System.out.println(minNo);
    }
}
