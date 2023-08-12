package AdvanceDSA.BinarysearchPlaylist;
/*
Given a matrix of integers A of size N x M in which each row is sorted.
Find and return the overall median of matrix A.
NOTE: No extra memory is allowed.
NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
Problem Constraints
1 <= N, M <= 10^5
1 <= N*M <= 10^6
1 <= A[i] <= 10^9
N*M is odd
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P9_MatrixMedian {
    public static int searchnoless(int [] A,int B){
        int index=0;
        int s=0;
        int e=A.length-1;
        while (s<=e){
            int mid=(s+e)/2;
            if(A[mid]>B){
                e=mid-1;
            }
            else if(A[mid]==B){
                if(mid==0){
                    index=1;
                }
                else {
                    index = mid;
                }
                s=mid+1;
            }
            else{
                index=mid+1;
                s=mid+1;
            }
        }
        return index;
    }
    public static int noOfelement(int [][]A,int k){
        int ans=0;
        for(int i=0;i<A.length;i++){
            int [] arr=new int[A[0].length];
            for(int j=0;j<A[0].length;j++){
                arr[j]=A[i][j];
            }

            ans+=searchnoless(arr,k);
            System.out.println(Arrays.toString(arr)+" no of element less than k "+ans);
        }
        System.out.println("k "+k+ " "+ans);
        return ans;
    }

    public static int findMedian(int[][] A) {
        int r=A.length;
        int c=A[0].length;
        int N=r*c;
        int s=Integer.MAX_VALUE;
        int e=Integer.MIN_VALUE;
        int ans=-1;
        for(int i=0;i<A.length;i++){
            s= Math.min(s,A[i][0]);
            e=Math.max(e,A[i][A[0].length-1]);
        }
        if(r==1){
            return N/2;
        }
        //System.out.println("min "+s+" max "+e);
        while (s<=e){
            int mid=(s+e)/2;
            System.out.println("k "+mid);
            int no=noOfelement(A,mid);
            //System.out.println(" no "+no+" n/2 "+N/2);
            if(no==N/2){
                ans=mid;
                s=mid+1;
            }
            else if(no<N/2){
                s=mid+1;
            }
            else {
                e=mid-1;
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int [][] A=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){

                A[i][j]=sc.nextInt();
            }
        }
        int index=findMedian(A);
        System.out.println("Index of median is "+index);
    }
}
