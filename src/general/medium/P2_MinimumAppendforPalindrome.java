package general.medium;
/*
Problem Description

Given a string A consisting of lowercase characters.

We need to tell minimum characters to be appended (insertion at end) to make the string A a palindrome.



Problem Constraints

1 <= |A| <= 105

A consists only of lower-case characters.



Input Format

First argument is an string A.



Output Format

Return a integer denoting the minimum characters to be appended (insertion at end) to make the string A a palindrome.



Example Input

Input 1:

 A = "abede"
Input 2:

 A = "aabb"


Example Output

Output 1:

 2
Output 2:

 2
 */

import java.util.Scanner;

public class P2_MinimumAppendforPalindrome {
    //KMP algorithm
    public static int longestPrefixSuffix(String S){
        int n=S.length();
        int [] lps=new int[n];
        int len=0;
        int i=1;
        while (i<n){
            if(S.charAt(i)==S.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else {

                if(len!=0){
                    len=lps[len-1];
                }
                else {
                    lps[i]=0;
                    i++;
                }
            }
        }
        return lps[n-1];
    }



    public static int solve(String A) {
        StringBuilder rev=new StringBuilder(A).reverse();
        StringBuilder pattern=rev.append('$');
        pattern.append(A);
        String S=pattern.toString();
        //System.out.println(pattern);
        int lenofexistingPalind=longestPrefixSuffix(S);
        return A.length()-lenofexistingPalind;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int minAppend=solve(A);
        System.out.println("Minimum character append at the end to make it palindrome "+minAppend);

    }
}
