package Strings.Intermediate;

import java.util.Scanner;
/*
You are given a string S, and you have to find all the amazing substrings of S.

An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 */

public class P$_NoOfMagicalSubString {
    public static int solve(String A) {
        int N=A.length();
        long count=1;
        int ans=0;
        for(int i=N-1;i>=0;i--){
            if(A.charAt(i)=='A'||A.charAt(i)=='E'
            ||A.charAt(i)=='I'||A.charAt(i)=='O'||A.charAt(i)=='U'||A.charAt(i)=='a'||A.charAt(i)=='e'||A.charAt(i)=='i'
                    ||A.charAt(i)=='o'||A.charAt(i)=='u'){
                ans+=count;
            }
            count++;
        }
        ans=ans%(10003);
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int x=solve(A);
        System.out.println("No of occurrence of magical substring is "+x);
    }
}
