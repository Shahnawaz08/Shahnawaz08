package AdvanceDSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class P5_0_1_Knapsack {
    public static int knapsackDp(int [] profit,int [] wt,int W,int N,int [][]dp){

        //Base case if no element left or no capacity left
        if(N==0||W==0){
            return 0;
        }
        if(dp[N][W]!=-1) return dp[N][W];


        if(wt[N-1]<=W){
            int max=Math.max(knapsackDp(profit,wt,W,N-1,dp),profit[N-1]+knapsackDp(profit,wt,W-wt[N-1],N-1,dp));
            dp[N][W]=max;
            return max;
        }
        else {
            return knapsackDp(profit,wt,W,N-1,dp);
        }

    }
    public static int knapsack(int [] profit,int [] wt,int W,int N){

        //Base case if no element left or no capacity left
        if(N==0||W==0){
            return 0;
        }


        if(wt[N-1]<=W){
            int max=Math.max(knapsack(profit,wt,W,N-1),profit[N-1]+knapsack(profit,wt,W-wt[N-1],N-1));
            return max;
        }
        else {
            return knapsack(profit,wt,W,N-1);
        }

    }

    public static int solve(int[] A, int[] B, int C) {
        int N=A.length ;//total number of items;
        int max_profit=knapsack(A,B,C,N);
        System.out.println(max_profit);
        int [][] dp=new int[N+1][C+1];
        for (int [] temp:dp) {
            Arrays.fill(temp,-1);
        }
        System.out.println(Arrays.deepToString(dp));
        max_profit=knapsackDp(A,B,C,N,dp);
        System.out.println("profit using dp "+max_profit);
        System.out.println(dp[N][C]);
        return max_profit;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array ");
        int N=sc.nextInt();
        int [] A=new int[N];
        int [] B=new int[N];
        System.out.println("Enter values of the the elements");
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter weight of the the elements");
        for(int i=0;i<N;i++){
            B[i]=sc.nextInt();
        }
        System.out.println("Enter capacity of the knapsack");
        int C=sc.nextInt();
        int maxval=solve(A,B,C);
        System.out.println("Maximum profile that can be achieved is "+maxval);
    }
}
