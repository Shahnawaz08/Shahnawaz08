package AdvanceDSA.Recursion;
/*
Given a number A, we need to find the sum of its digits using recursion.
 */

import java.util.Scanner;

public class P1_SumOfDigit {
    public static int solve(int A){
        if(A==0){
            return 0;
        }
        return A%10+solve(A/10);
    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int sum=solve(A);
        System.out.println(sum);
    }

}
