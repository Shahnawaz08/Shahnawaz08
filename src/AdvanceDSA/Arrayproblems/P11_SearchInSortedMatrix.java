package AdvanceDSA.Arrayproblems;
/*
Given a matrix of integers A of size N x M and an integer B.
In the given matrix every row and column is sorted in increasing order. Find and return the position of B in the matrix in the given form:
If A[i][j] = B then return (i * 1009 + j)
If B is not present return -1.

Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
 */

import java.util.Scanner;

public class P11_SearchInSortedMatrix {
    public static int solve(int[][] A, int B) {
        int index=-1;
        //start from top right corner
        int N=A.length;
        int i=0;
        int j=A[0].length-1;
        while (i<N && j>=0){
            int current_val=A[i][j];
            if(current_val==B){
                if(index==-1){
                    index=(i+1)*1009+j+1;
                }
                else {
                    index = Math.min(index, (i + 1) * 1009 + j + 1);
                }
                j--;
            } else if (current_val>B) {
                j--;
            }
            else {
                i++;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int [][] arr=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("Element to be found");
        int B= sc.nextInt();

        int index_val=solve(arr,B);
        System.out.println(index_val);
    }
}
