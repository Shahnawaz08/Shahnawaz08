package AdvanceDSA.ModularArithmetic;
/*
Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.
A-1 mod B is also known as modular multiplicative inverse of A under modulo B.

Problem Constraints
1 <= A <= 109
1<= B <= 109
B is a prime number
 */

import java.util.Scanner;

public class P3_PrimeModuoInverse {
    public static int power(int A, int B,int C) {
        if(A==0){
            return 0;
        }
        if(B==0){
            return 1;
        }
        long pow=power(A,B/2,C);
        pow=(pow*pow)%C;
        if(B%2==0){
            return (int)pow;
        }
        pow=(pow*A)%C;
        return (int)pow;

    }
    public static int solve2(int A, int B) {
        int pow=power(A,B-2,B);
        return pow;
    }
    public static int solve(int A, int B) {
        for (int x = 1; x < B; x++)
            if (((A%B) * (x%B)) % B == 1)
                return x;
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();

        int B=sc.nextInt();

        int no=solve(A,B);
        System.out.println(no);
        no=solve2(A,B);
        System.out.println(no);
    }
}
