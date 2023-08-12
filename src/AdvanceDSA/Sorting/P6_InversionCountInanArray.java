package AdvanceDSA.Sorting;
/*
Given an array of integers A. If i < j and A[i] > A[j],
 then the pair (i, j) is called an inversion of A.
 Find the total number of inversions of A modulo (109 + 7).
Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 10^9
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class P6_InversionCountInanArray {

        public static long merge(int[] A,int s,int mid,int e){
            int[] temp = new int[e-s+1];
            int i= s,j=mid+1,k=0;
            long ans=0,mod = 1000000007;
            while(i<=mid && j<=e){
                if(A[i]>A[j]){
                    temp[k]=A[j];
                    j++;
                    k++;
                    ans = (ans%mod + (long)((mid-i+1)%mod))%mod;
                }
                else if(A[j]>=A[i]){
                    temp[k] = A[i];
                    k++;
                    i++;
                }
            }
            while(i<=mid){
                temp[k]=A[i];
                k++;
                i++;
            }
            while(j<=e){
                temp[k]=A[j];
                k++;
                j++;
            }
            i=s;
            for(i=s;i<=e;i++){
                A[i]=temp[i-s];
            }
            return ans%mod;
        }
        public static long mergeSort(int[] A,int s,int e){
            long ans=0,mod = 1000000007;
            if(s<e){
                int mid = (e+s)/2;
                ans += mergeSort(A,s,mid);
                ans %= mod;
                ans += mergeSort(A,mid+1,e);
                ans %= mod;
                ans += merge(A,s,mid,e);
                ans %= mod;
            }
            return ans%mod;
        }
        public static int solve(int[] A) {
            int s=0,e=A.length-1;
            long ans=0,mod=1000000007;
            ans =(int)(mergeSort(A,s,e));
            return (int)(ans%mod);
        }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int noofcount=solve(A);
        System.out.println(noofcount);
    }
}
