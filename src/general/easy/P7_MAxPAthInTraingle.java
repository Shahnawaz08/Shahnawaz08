package general.easy;
/*
Problem Description
Given a 2D integer array A of size N * N representing a triangle of numbers.
Find the maximum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
NOTE:

Adjacent cells to cell (i,j) are only (i+1,j) and (i+1,j+1)
Row i contains i integer and n-i zeroes for all i in [1,n] where zeroes represents empty cells.


Problem Constraints
0 <= N <= 1000
0 <= A[i][j] <= 1000
 */

import java.util.Arrays;
import java.util.Scanner;

public class P7_MAxPAthInTraingle {
    public static  int getmaxlen(int i,int j,int N,int [][]A,int [][] dp){
        //base case
        if(i==N){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        // Recursive case
        int belowblock=A[i][j]+getmaxlen(i+1,j,N,A,dp);
        int adj=A[i][j]+getmaxlen(i+1,j+1,N,A,dp);
        int maxsum=Math.max(belowblock,adj);
        return dp[i][j]=maxsum;
    }
    public static int solve(int[][] A) {
        int N=A.length;
        int i=0;
        int j=0;
        int [][] dp=new int[N][N];
        for(int [] temp:dp){
            Arrays.fill(temp,-1);
        }
        int maxlen=getmaxlen(i,j,N,A,dp);
        return  maxlen;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [][] A=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                A[i][j]=sc.nextInt();
            }
        }
        int max=solve(A);
        System.out.println("Maximum size of path is "+max);
    }
}
