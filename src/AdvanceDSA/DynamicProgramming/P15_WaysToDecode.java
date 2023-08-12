package AdvanceDSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;
/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.



Problem Constraints
1 <= length(A) <= 105



Input Format
The first and the only argument is a string A.



Output Format
Return an integer, representing the number of ways to decode the string modulo 109 + 7.



Example Input
Input 1:

 A = "12"
Input 2:

 A = "8"


Example Output
Output 1:

 2
Output 2:

 1
 */

public class P15_WaysToDecode {
    public static int helper(String A,int i,int len,int mod,int [] dp){
        if(i==len &&!(A.charAt(i)-'0'==0) || i==len+1) {
            System.out.println(i);
            return 1;
        }
        if(i>len) return 0;
        if(A.charAt(i)-'0'==0) return 0;
        if(dp[i]!=-1) return dp[i];
        int ones=helper(A,i+1,len,mod,dp);
        int pair=0;
        if(i+1<=len){
            int fst=A.charAt(i)-'0';
            int sc=A.charAt(i+1)-'0';
            int no=fst*10+sc;
            if(fst==0 ) pair=0;
            else if(no<=26){
                pair=helper(A,i+2,len,mod,dp);
            }


        }
        return dp[i]=(ones+pair)%mod;
    }

    public static int numDecodings(String A) {
        int [] dp=new int[A.length()];
        Arrays.fill(dp,-1);
        int len=A.length()-1;
        int i=0;
        int mod=1000000007;
        int noOfway=helper(A,i,len,mod,dp);
        return noOfway;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int noOfWay=numDecodings(A);
        System.out.println(noOfWay);
    }
}
