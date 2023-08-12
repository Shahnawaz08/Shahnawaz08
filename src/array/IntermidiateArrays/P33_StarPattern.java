package array.IntermidiateArrays;
/*
Write a program to input an integer N from user and print hollow diamond star pattern series of N lines.

See example for clarifications over the pattern.



Problem Constraints

1 <= N <= 1000
 */

import java.util.Scanner;

public class P33_StarPattern {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++) {
                System.out.print("*");
            }
            for(int j=1;j<i;j++) {
                System.out.print(" ");
            }
            for(int j=1;j<i;j++) {
                System.out.print(" ");
            }
            for(int j=1;j<=n-i+1;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++) {
                System.out.print("*");
            }
            for(int j=1;j<=n-i;j++) {
                System.out.print(" ");
            }
            for(int j=1;j<=n-i;j++) {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
