package Recursion_Problems;

import java.util.Scanner;
/*
Given a number A, check if it is a magic number or not.
A number is said to be a magic number if the sum of its
digits is calculated till a single digit recursively by
adding the sum of the digits after every addition. If
the single digit comes out to be 1, then the number is a magic number.


 */

public class P5_magicNumber {
    public static int sumofdigit(int A) {
            if (A == 0) {
                return 0;
            }
            int sum = A % 10;
            A = A / 10;
            sum = sum + sumofdigit(A);


        return sum;

    }
    public static int solve(int A){
        int sum=sumofdigit(A);
        System.out.println(sum);
        while(sum>9){
            int temp=sumofdigit(sum);
            System.out.println(sum);
            sum=temp;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int Sum=solve(N);
        System.out.println("Sum of digit of given number is "+Sum);
    }
}
