package AdvanceDSA.DynamicProgramming;
/*
Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.
Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
Since the answer can be large, output answer modulo 1000000007
 */

import java.util.Arrays;
import java.util.Scanner;

public class P2_NdigitNumber {
    static int getAns(int i,int A,int B,int [][] dp){
        if(i==A){
            if(B==0) return 1;
            return 0;
        }
        if(B<0) return 0;
        if(dp[i][B]!=-1) return dp[i][B];
        int lb=0;
        if(i==0) lb=1;
        int ans=0;
        for(int j=lb;j<=9;j++){
            ans=(ans+getAns(i+1,A,B-j,dp))%1000000007;
            dp[i][B]=ans;
        }
        return ans;
    }
    public static int solve(int A, int B) {
        int [][] dp=new int[1001][10001];
        for(int i=0;i<=1000;i++){
            Arrays.fill(dp[i],-1);
        }
        //System.out.println(Arrays.deepToString(dp));
        int no =getAns(0,A,B,dp);
        return no;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int  A=sc.nextInt();
        int  B=sc.nextInt();
        int no=solve(A,B);
        System.out.println("Number of A digit number whose sum is b is "+no);
    }
}
