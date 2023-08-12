package AdvanceDSA.BinarysearchPlaylist;
/*
Farmer John has built a new long barn with N stalls.
Given an array of integers A of size N where each element of the array represents
the location of the stall and an integer B which represents the number of cows.

His cows don't like this barn layout and become aggressive towards each other
once put into a stall. To prevent the cows from hurting each other,
John wants to assign the cows to the stalls, such that the minimum distance
between any two of them is as large as possible. What is the largest minimum distance?



Problem Constraints
2 <= N <= 100000
0 <= A[i] <= 109
2 <= B <= N
 */

import java.util.Arrays;
import java.util.Scanner;

public class P8_aggressiveCows {
    public static boolean canPlace(int [] A,int dist,int B){
        int k=0;
        int last_placd=A[0];
        int cnt=1;
        for(int i=1;i<A.length;i++){
            if(A[i]-last_placd>=dist){
                last_placd=A[i];
                cnt++;

            }
            if(cnt==B){
                return true;
            }
        }
        return false;
    }

    public static int solve(int [] A,int B){
        Arrays.sort(A);
        int s=0;
        int e=A[A.length-1]-A[0];
        int current_ans=0;
        while (s<=e){
            int mid=(s+e)/2;
            if(canPlace(A,mid,B)){
                current_ans=mid;
                s=mid+1;

            }
            else {
                e=mid-1;
            }
        }
        return current_ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int B=sc.nextInt();
        int maxofMindist=solve(A,B);
        System.out.println(maxofMindist);
    }
}
