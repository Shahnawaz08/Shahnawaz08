package AdvanceDSA.ModularArithmetic;
/*
Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).

"^" means power,
"%" means "mod", and
"!" means factorial.

Problem Constraints
1 <= A, B <= 5e5
 */

import java.util.Scanner;

public class P5_VeryLArgePower {
    public static int pow(int A, int B, int C) {
        if(A==0){
            return 0;
        }
        if(B==0){
            return 1;
        }
        long tempPow=(long)pow(A,B/2,C);
        long power=(tempPow*tempPow)%C;
        power=(power+C)%C;
        if(B%2==0){
            return (int)power;
        }
        power= (A*power)%C;
        return (int)(power+C)%C;

    }
    public static long fact(int A,int B,int mod){
        if(B==1){
            return A;
        }
        return fact(pow(A,B,mod),B-1,mod);
    }

    public static int solve(int A, int B) {
        int mod=1000000007;
        long ans=fact(A,B,mod);
        return (int)(ans%mod);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();

        int B=sc.nextInt();

        int no=solve(A,B);
        System.out.println(no);

    }
}
