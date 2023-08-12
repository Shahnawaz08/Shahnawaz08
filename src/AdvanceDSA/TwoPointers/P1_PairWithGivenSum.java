package AdvanceDSA.TwoPointers;
/*
Problem Description
Given an one-dimensional integer array A of size N and an integer B.
Count all distinct pairs with difference equal to B.
Here a pair is defined as an integer pair (x, y), where x and y
are both numbers in the array and their absolute difference is B.

Problem Constraints
1 <= N <= 104

0 <= A[i], B <= 105
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class P1_PairWithGivenSum {
    public static int solve(int[] A, int B) {
        int N=A.length;
        if(N==1){
            return 0;
        }
        int i=0;
        int j=1;
        int ans=0;
        Arrays.sort(A);

        while(j<N){
            if(A[j]-A[i]==B){
                ans++;
                int s=i;
                i++;
                while(i<N&&A[s]==A[i]){
                    i++;
                }
                int e=j;
                j++;
                while(j<N&&A[e]==A[j]){
                    j++;
                }
            }
            else if(A[j]-A[i]>B){
                i++;
                if(i==j){
                    j++;
                }
            }
            else j++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter the difference");
        int B=sc.nextInt();
        int uniqPair=solve(A,B);
        System.out.println("Uniq pair differnce "+uniqPair);

    }
}
