package Strings.Intermediate;

import java.util.Scanner;
/*
 You have given a string A having Uppercase English letters.
You have to find how many times subsequence "AG" is there in the given string.
NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
 */

public class P1NoOfOccOfSubStr {
    public static int solve(String A) {
        int N=A.length();
        int count=0;
        for(int i=0;i<N-1;i++){
            if(A.charAt(i)=='A' && A.charAt(i+1)=='G'){
                count++;
            }
        }
        count=count%(10000007);
        return count;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int x=solve(A);
        System.out.println("No of occurance of AG is "+x);
    }
}
