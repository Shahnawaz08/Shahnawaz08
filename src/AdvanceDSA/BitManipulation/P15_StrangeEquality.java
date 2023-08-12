package AdvanceDSA.BitManipulation;
/*
Given an integer A.
Two numbers, X and Y, are defined as follows:

X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
Find and return the XOR of X and Y.

NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.

NOTE 2: Your code will be run against a maximum of 100000 Test Cases.
 */

import java.util.Scanner;

public class P15_StrangeEquality {
    public static int solve(int A) {
        int x=0;
        int y=0;
        int count=0;
        int Acopy=A;
        while (Acopy!=0){
            if((Acopy&1)==0){
                x+=1<<count;
            }
            count++;
            Acopy=Acopy>>1;
        }
        System.out.println(x);
        count=0;
        Acopy=A;
        while (Acopy!=0){
            count++;
            Acopy=Acopy>>1;
        }
        y=1<<count;
        System.out.println(y);
        return x^y;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();

        int no=solve(A);
        System.out.println(no);
    }
}
