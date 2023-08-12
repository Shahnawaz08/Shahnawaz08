package AdvanceDSA.BinarysearchPlaylist;
/*
Given a bitonic sequence A of N distinct elements,
write a program to find a given element B in the bitonic sequence in O(logN) time.
NOTE:
A Bitonic Sequence is a sequence of numbers which is first strictly increasing
then after a point strictly decreasing.

Problem Constraints
3 <= N <= 105

1 <= A[i], B <= 108

Given array always contain a bitonic point.
Array A always contain distinct elements.
 */

import java.util.Scanner;

public class P12_SearchInBitonocArray {
    public static int findPivot(int [] A){
        int s=0;
        int e=A.length-1;
        int index=-1;
        while (s<=e){
            int mid=(s+e)/2;
            if(A[mid]>A[mid-1]&&A[mid]>A[mid+1]){
                return mid;
            }
            if(A[mid]>A[mid-1]&&A[mid]<A[mid+1]){
                s=mid+1;
            }
            else {
                e=mid-1;
            }

        }
        return index;
    }

    public static int solve(int[] A, int B) {
        int pivot=findPivot(A);
        System.out.println(pivot);
        int s1=0;
        int e1=pivot;
        int s2=pivot+1;
        int e2=A.length-1;
        System.out.println("s1 "+s1+" e1 "+e1+" s2 "+s2+" e2 "+e2);
        while (s1<=e1){
            int mid=(s1+e1)/2;
//            system.out.println("mid A[mid] "+mid+" "+A[mid]);
            if(A[mid]==B){
                return mid;
            }
            if(A[mid]<B){
                s1=mid+1;
            }
            else {
                e1=mid-1;
            }
        }
        while (s2<=e2){
            int mid=(s2+e2)/2;
            System.out.println("mid A[mid] "+mid+" "+A[mid]);
            if(A[mid]==B){
                return mid;
            }
            else if(A[mid]<B){
                e2=mid-1;
            }else {
                s2=mid+1;
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
        System.out.println("Enter number to search");
        int B=sc.nextInt();
        int magicalNum=solve(A,B);
        System.out.println("Magical number "+magicalNum);
    }
}
