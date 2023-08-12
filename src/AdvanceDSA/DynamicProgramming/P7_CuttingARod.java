package AdvanceDSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class P7_CuttingARod {
    public static int profitfinderDp(int [] A,int N,int [] dp){
        //base case
        if(N<=0){
            return 0;
        }
        if(dp[N]!=-1) return dp[N];
        int maxprofit=0;
        for(int i=0;i<A.length;i++){
            if(i+1<=N) {
                int tempProfit = A[i] + profitfinderDp(A, N - i - 1,dp);
                maxprofit = Math.max(tempProfit, maxprofit);
            }
        }
        dp[N]=maxprofit;
        return maxprofit;
    }
    public static int profitfinder(int [] A,int N){
        System.out.println("value of n in start "+N);
        //base case
        if(N<=0){
            return 0;
        }
        int maxprofit=0;
        for(int i=0;i<A.length;i++){

                int tempProfit = A[i] + profitfinder(A, N - i - 1);
                maxprofit = Math.max(tempProfit, maxprofit);

        }
        System.out.println("value of n in start as well as max value  "+N+" "+maxprofit);
        return maxprofit;
    }

    public static int solve(int[] A) {
        int N=A.length;
        int profit=profitfinder(A,N);
        int [] dp=new int[N+1];
        Arrays.fill(dp,-1);
        int profitdp=profitfinderDp(A,N,dp);
        System.out.println("profit using dp "+profitdp);

        return profit;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        System.out.println("Enter element of an array");
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int maxProfit=solve(A);
        System.out.println("Maximum profit is "+maxProfit);
    }
}
