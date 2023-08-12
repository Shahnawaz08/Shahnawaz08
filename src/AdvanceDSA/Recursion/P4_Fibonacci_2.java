package AdvanceDSA.Recursion;
/*
The Fibonacci numbers are the numbers in the following integer sequence.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..

In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation:

Fn = Fn-1 + Fn-2

Given a number A, find and return the Ath Fibonacci Number.

Given that F0 = 0 and F1 = 1.
 */

import java.util.Scanner;

public class P4_Fibonacci_2 {
    public static int findAthFibonacci(int A) {
        if(A==0 ||A==1){
            return A;
        }
        return findAthFibonacci(A-1)+findAthFibonacci(A-2);

    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int sum=findAthFibonacci(A);
        System.out.println(sum);
    }
}
