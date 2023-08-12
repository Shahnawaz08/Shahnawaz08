package HashingProblems;
/*
Given a number A, find if it is COLORFUL number or not.
If number A is a COLORFUL number return 1 else, return 0.

What is a COLORFUL Number:
A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.
Problem Constraints
1 <= A <= 2 * 109
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P20_ColorfulNumber {
    public static int colorful(int A) {
        HashSet<Long> set=new HashSet<>();
       // for()
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A= sc.nextInt();
        int isColorful=colorful(A);
        System.out.println(isColorful);
    }
}
