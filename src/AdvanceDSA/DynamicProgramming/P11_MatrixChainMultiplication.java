package AdvanceDSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;
/*
Given an array of integers A representing chain of 2-D matices such that the dimensions of ith matrix is A[i-1] x A[i].
Find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications,
but merely to decide in which order to perform the multiplications.
Return the minimum number of multiplications needed to multiply the chain.



Problem Constraints
1 <= length of the array <= 1000
1 <= A[i] <= 100
 */

public class P11_MatrixChainMultiplication {

//====================================With Dp============================================
    public static int multiplyWithDp(int [] A,int i,int j,int [][]dp){
        //Base Case
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        //we have to take minimum of all
        int minCost=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int L=multiplyWithDp(A,i,k,dp);
            int R=multiplyWithDp(A,k+1,j,dp);
            int cost=A[i-1]*A[k]*A[j];
            int totalCost=L+R+cost;
            minCost= Math.min(minCost,totalCost);
        }
        return dp[i][j]=minCost;
    }

//=============================Without Dp=====================================
    public static int multiply(int [] A,int i,int j){//Without dp
        //Base Case
        if(i==j){
            return 0;
        }
        //we have to take minimum of all
        int minCost=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int L=multiply(A,i,k);
            int R=multiply(A,k+1,j);
            int cost=A[i-1]*A[k]*A[j];
            int totalCost=L+R+cost;
            minCost= Math.min(minCost,totalCost);
        }
        return minCost;
    }

    public static int solve(int[] A) {
        int min=multiply(A,1,A.length-1);
        int N=A.length;
        int [][] dp=new int[N][N];
        for (int [] temp:dp) {
            Arrays.fill(temp,-1);
        }
        min=multiplyWithDp(A,1,N-1,dp);
        System.out.println(Arrays.deepToString(dp));
        return min;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int minMultiplication=solve(A);
        System.out.println("Minimum multiplication required is "+minMultiplication);
    }
}
