package AdvanceDSA.Combinatorics;
/*
Given three integers A, B, and C, where A represents n, B represents r, and C represents p and p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

NOTE: For this problem, we are considering 1 as a prime.



Problem Constraints
1 <= A <= 106
1 <= B <= A
A <= C <= 109+7
 */

import java.util.Scanner;

public class P3_ComputeNCRmodP {
    public static long binpow(long a,long b,long m){
        if(a==0) return 0;
        if(b==0) return 1;
        long t=binpow(a,b/2,m)%m;
        t=(t*t)%m;
        if(b%2==0) return t;
        else return (a*t)%m;

    }
    public static int solve(int A, int B, int C) {
        long []fact=new long[1000005];
        fact[0]=1L;
        for(int i=1;i<=A;i++){
            fact[i]=(fact[i-1]*i)%C;
        }
        long ans=fact[A];
        ans=(ans*binpow(fact[B],C-2,C))%C;
        ans=(ans*binpow(fact[A-B],C-2,C))%C;
        return (int)ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
        int val=solve(A,B,C);
        System.out.println(val);
        //System.out.println(comb(3,0));
    }
}
