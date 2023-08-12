package AdvanceDSA.Arrayproblems;
/*
Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.

Note: It is possible to swap any two elements, not necessarily consecutive.



 */

import java.util.Scanner;

public class P14_minimumSwap {
    public static int solve(int[] A, int B) {
        int window_size=0;
        int ans=0;
        int count=0;
        for(int i=0;i<A.length;i++){
            if(A[i]<=B){
                window_size++;
            }
        }
        for(int i=0;i<window_size;i++){
            if(A[i]>B)count++;
        }
        ans=count;
        int si=0;
        int ei=window_size-1;
        while(ei<A.length-1)
        {
            ei++;
            if(A[ei] > B)count++;
            if(A[si] > B)count--;
            si++;
            ans=Math.min(ans,count);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("elements");
        int B=sc.nextInt();
        int minswap=solve(arr,B);
        System.out.println(minswap);
    }
}
