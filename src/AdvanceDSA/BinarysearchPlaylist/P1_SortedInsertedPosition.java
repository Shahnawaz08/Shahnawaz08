package AdvanceDSA.BinarysearchPlaylist;
/*
Problem Description
Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
If not, return the index where it would be if it were inserted in order.

NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.

Problem Constraints
1 <= N <= 106
 */

import java.util.Scanner;

public class P1_SortedInsertedPosition {
    public static int searchInsert(int[] A, int B) {
        if(A.length==0){
            return 0;
        }
        int e=A.length-1;
        int s=0;
        int index=-1;
        while (e>=s){
            int mid=(s+e)/2;
            if(A[mid]==B){
                return mid;
            }
            else if(A[mid]>B){
                index=mid;
                e=mid-1;
            }
            else {
                index=mid+1;
                s=mid+1;
            }

        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Target element");
        int B=sc.nextInt();
        int index=searchInsert(A,B);
        System.out.println("Index of "+B+" is "+index);
    }
}
