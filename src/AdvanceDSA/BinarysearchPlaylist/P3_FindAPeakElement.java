package AdvanceDSA.BinarysearchPlaylist;

import java.util.Scanner;
/*
Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time. The array may have duplicate elements.

Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109
 */

public class P3_FindAPeakElement {
    public static int solve(int[] A) {
        int N=A.length;
        if(N==1){
            return A[0];
        }
        if(A[0]>A[1]){
            return A[0];
        }
        if(A[N-1]>A[N-2]){
            return A[N-1];
        }

        int s=0;
        int e=A.length-1;
        while (s<=e){
            int mid=(s+e)/2;
            int left=0;
            int right=0;
            if(mid!=0){
                left=mid-1;
            }
            if(mid!=A.length-1){
                right=mid+1;
            }
            if(A[left]<=A[mid]&&A[mid]>=A[right]){
                //System.out.println("hii");
                return A[mid];

            }
            if(A[left]>A[mid]){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }

        int index=solve(A);
        System.out.println("Index of peak is "+index);
    }
}
