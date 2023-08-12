package AdvanceDSA.DynamicProgramming;
/*
Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.
This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.


Problem Constraints
1 <= A <= 1000
1 <= |B| <= 1000
1 <= B[i] <= 1000
1 <= C[i] <= 1000
 */

import java.util.Arrays;
import java.util.Scanner;

public class P12_UnboundedKnapsack {

//=====================With Dp Bottom up======================================
    public static int unboundedKnapsackBottomUp(int W,int [] val,int [] weight){
        int N=val.length;
        int [] dp=new int[W+1];
        int i=0;
        dp[i]=0;
        for(i=1;i<=W;i++){
            //int max= Integer.MAX_VALUE;
            for(int j=0;j<N;j++){
                int with_include=Integer.MIN_VALUE;
                if(i>=weight[j]) with_include=val[j]+dp[i-weight[j]];
                //int without_include=dp[i]
                dp[i]=Math.max(dp[i],with_include);
            }
        }
        return dp[W];
    }

//===================== With Dp (Top Down)==================================================
    public static int unboundedKnapsackDp(int i,int w,int [] val,int [] weight,int N,int [][]dp){
        //base case
        if(i==N){
            return 0;
        }
        //dp case
        if(dp[i][w]!=-1) return dp[i][w];
        //recursive case
        if(w>=weight[i]){
            return dp[i][w]=Math.max(val[i]+unboundedKnapsackDp(i,w-weight[i],val,weight,N,dp),unboundedKnapsackDp(i+1,w,val,weight,N,dp));
        }
        else {
            return dp[i][w]=unboundedKnapsackDp(i+1,w,val,weight,N,dp);
        }
    }

//========================Without Dp=====================================================
    public static int unboundedKnapsack(int i,int w,int [] val,int [] weight,int N){
        //base case
        if(i==N){
            return 0;
        }
        //recursive case
        if(w>=weight[i]){
            return Math.max(val[i]+unboundedKnapsack(i,w-weight[i],val,weight,N),unboundedKnapsack(i+1,w,val,weight,N));
        }
        else {
            return unboundedKnapsack(i+1,w,val,weight,N);
        }
    }
    public static int solve(int A, int[] B, int[] C) {
        int n=B.length;
        int maxval=unboundedKnapsack(0,A,B,C,n);
        int [][] dp=new int[n][A+1];
        for(int [] temp:dp){
            Arrays.fill(temp,-1);
        }
        maxval=unboundedKnapsackDp(0,A,B,C,n,dp);
        System.out.println("answer with bottom up approach "+unboundedKnapsackBottomUp(A,B,C));
        return maxval;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter maximum weight of Knapsack");
        int A=sc.nextInt();
        System.out.println("Enter number of items ");
        int N=sc.nextInt();
        System.out.println("Enter values os item");
        int [] B=new int[N];
        for (int i=0;i<N;i++){
            B[i]=sc.nextInt();
        }
        System.out.println("Enter weight of items");
        int [] C=new int[N];
        for(int i=0;i<N;i++){
            C[i]=sc.nextInt();
        }
        int maxVal=solve(A,B,C);
        System.out.println("Maximum value we get "+maxVal);

    }
}
