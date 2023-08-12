package Recursion_Problems;

import java.util.Scanner;
/*
Given a number A, we need to find the sum of its digits using recursion.
 */

public class P3_SumOfDigit {
    public static int solve(int A) {
        if(A==0){
            return 0;
        }
        int sum=A%10;
        A=A/10;
        sum=sum+solve(A);
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int Sum=solve(N);
        System.out.println("Sum of digit of given number is "+Sum);
    }
}
