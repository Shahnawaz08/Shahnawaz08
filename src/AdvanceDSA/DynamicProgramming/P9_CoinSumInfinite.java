package AdvanceDSA.DynamicProgramming;
/*
Problem Description
You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.

NOTE:
Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).
Problem Constraints
1 <= A <= 500
1 <= A[i] <= 1000
1 <= B <= 50000
 */

import java.util.Arrays;
import java.util.Scanner;

public class P9_CoinSumInfinite {
    public static int coinDp(int [] coins,int rem,int []dp){
        if(rem==0){
            return 0;
        }
        if(dp[rem]!=-1) return dp[rem];

        int count=0;
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=rem){
                int temp_count=1+coinDp(coins,rem-coins[i],dp);
                count=Math.max(count,temp_count);
            }
        }
        return dp[rem]=count;
    }
    public static int fun(int [] coins,int rem){
        if(rem==0){
            return 0;
        }
        int count=0;
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=rem){
                int temp_count=1+fun(coins,rem-coins[i]);
                count=Math.max(count,temp_count);
            }
        }
        return count;
    }
    public static int coinchange2(int[] A, int B) {
        int change =fun(A,B);
        int [] dp=new int[B+1];
        Arrays.fill(dp,-1);
        change=coinDp(A,B,dp);
        return change;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter amount whose change u need");
        int B=sc.nextInt();
        int noOfWay=coinchange2(A,B);
        System.out.println("Number of way we get the change of "+B+" is "+noOfWay);
    }
}
