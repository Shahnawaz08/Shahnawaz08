package AdvanceDSA.BitManipulation;

import java.util.Scanner;

/*
Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.

Return the count modulo 109 + 7.
 */
public class P14_countToatalSetBits {
    public static int solve(int A) {
        int ans=0;
        A=A+1;
        for(int i=0;i<31;i++){
            int noOfbitsincomplPair=((A/(1<<(i+1)))*(1<<i))%1000000007;
            ans=(ans+noOfbitsincomplPair)%1000000007;
            if(A%(1<<(i+1))>(1<<i)){
                int noOfbitinIncomplpair=(A%(1<<(i+1)))-(1<<i);
                ans=(ans+noOfbitinIncomplpair)%1000000007;
            }
            //System.out.println(ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();

        int no=solve(A);
        System.out.println(no);
    }
}
