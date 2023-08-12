package AdvanceDSA.GcdProblems;
/*
Scooby has 3 three integers A, B, and C.
Scooby calls a positive integer special if it is divisible by B
and it is divisible by C. You need to tell the number of special integers less than or equal to A.

Problem Constraints
1 <= A, B, C <= 109
 */

import java.util.Scanner;

public class P7_DivisorGame {
    public static int getgcd(int A, int B) {
        while (A!=0){
            int temp=A;
            A=B%A;
            B=temp;
        }
        return B;
    }
    public static int getlcm(int A,int B){
        int lcm=(A*B)/getgcd(A,B);
        return lcm;
    }
    public static int solve(int A, int B, int C) {
        int lcm=getlcm(B,C);
        int noOfNumber=A/lcm;
        return noOfNumber;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();

        int B=sc.nextInt();
        int C=sc.nextInt();

        int no=solve(A,B,C);
        System.out.println(no);
    }
}
