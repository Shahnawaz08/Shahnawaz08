package AdvanceDSA.BitManipulation;
/*
Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.

Return the count modulo 109 + 7.
 */

import java.util.Scanner;

public class P10_TotalNoOfSetBit {
    public static int solve(int A) {
        int count=0;
        for(int i=1;i<=A;i++){
            int emt=i;
            while (emt!=0){
                int bit=emt&1;
                count=(count+bit)% 1000000007;
                emt=emt>>1;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int is=solve(N);
        System.out.println(is);
    }
}
