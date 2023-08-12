package AdvanceDSA.Recursion;
/*
Write a program to find the factorial of the given number A.
Problem Constraints
0 <= A <= 12
 */

import java.util.Scanner;

public class P5_Factorial {
    public static int solve(int A) {
        if(A==0){
            return 1;
        }
        return A*solve(A-1);
    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int sum=solve(A);
        System.out.println(sum);
    }
}
