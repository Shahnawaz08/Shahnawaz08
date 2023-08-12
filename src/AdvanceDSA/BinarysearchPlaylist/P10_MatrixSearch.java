package AdvanceDSA.BinarysearchPlaylist;

import java.util.Scanner;
/*
Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom, and columns are from left to right.


Problem Constraints
1 <= N, M <= 1000
1 <= A[i][j], B <= 106
 */

public class P10_MatrixSearch {
    public static int findemt(int[][] A,int B){
        int s=0;
        int N=A.length;
        int M=A[0].length;
        int e=N*M-1;
        while (s<=e){
            int mid=(s+e)/2;
            int row=mid/M;
            int col=mid%M;
            if(A[row][col]==B){
                return 1;
            }
            if(A[row][col]>B){
                e=mid-1;
            }
            else s=mid+1;
        }
        return -1;
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
        System.out.println("Enter number that u want to find ");
        int B=sc.nextInt();
        int index=findemt(A,B);
        System.out.println("Index of median is "+index);
    }
}
