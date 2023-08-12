package AdvanceDSA.BinarysearchPlaylist;
/*
Problem Description
Given a sorted array of integers A of size N and an integer B.
array A is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array,
return its index otherwise, return -1.
You may assume no duplicate exists in the array.
NOTE: Users are expected to solve this in O(log(N)) time.

Problem Constraints
1 <= N <= 1000000

1 <= A[i] <= 10^9

all elements in A are distinct.
 */

import java.util.Scanner;

public class P2_RotatedSortedArraySearch {
    public static int findPivot(int [] A){
        if(A.length==1){
            return 0;
        }
        int s=0;
        int e= A.length-1;
        int pivot=0;
        while (s<=e){
            int mid=(s+e)/2;
//            if(mid<=e &&A[mid]>A[mid+1] ){
//                pivot= mid+1;
//            }
//            else if(mid>=s &&A[mid]<A[mid+1]){
//                pivot=mid;
//            }
            int l,r;
            if(mid-1==-1){
                l=A[e];
            }
            else {
                l=A[mid-1];
            }
            if(mid==e){
                r=A[0];
            }else {
                r=A[mid+1];
            }
            if(l>A[mid]&&A[mid]<r){
                return mid;
            }
            if(l<A[mid]&&A[mid]>r){
                return mid+1;
            }


            if(A[mid]>A[s]){
                s=mid+1;
            } if(A[mid]<A[e])  {
                e=mid-1;
            }
        }
        return pivot;
    }
   public static int binarysearch(int []A,int s,int e,int B){
        int index=-1;
        while (s<=e){
            int mid=(s+e)/2;
            if(A[mid]==B){
                return mid;
            }
            else if(A[mid]>B){
                e=mid-1;
            }else {
                s=mid+1;
            }
        }
        return index;
   }

    public static int search(final int[] A, int B) {
        if(A.length==0){
            return 0;
        }
        int s=0;
        int e=A.length-1;
        int ans=0;
        int pivot=findPivot(A);
        if(B<=A[pivot-1]&&B>=A[s]){
            ans=binarysearch(A,s,pivot-1,B);
        }else {
            ans=binarysearch(A,pivot,e,B);
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
        System.out.println("Target element");
        int B=sc.nextInt();
        int index=search(A,B);
        System.out.println("Index of "+B+" is "+index);
    }
}
