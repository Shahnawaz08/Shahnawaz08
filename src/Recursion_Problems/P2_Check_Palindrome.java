package Recursion_Problems;

import java.util.Scanner;
/*
Write a recursive function that checks whether string A is a palindrome or Not.
Return 1 if the string A is a palindrome, else return 0.

Note: A palindrome is a string that's the same when read forward and backward.
 */

public class P2_Check_Palindrome {
    public static int solve(String A) {
        if (A.charAt(0) != A.charAt(A.length() - 1)) {
            return 0;
        }
        if (A.length() == 1 || A.length() == 2) {
            if (A.charAt(0) == A.charAt(A.length() - 1)) {
                return 1;

            }
        }
            StringBuilder sb=new StringBuilder();
            sb.append(A);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length()-1);
            String S=sb.toString();

            return solve(S);

        }

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String S = sc.next();
            int check=solve(S);
            System.out.println(check);

        }
    }

