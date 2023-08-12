package Recursion_Problems;

import java.util.Scanner;
/*
Write a recursive function that, given a string S, prints the characters of S in reverse order.


 */

public class P1_ReverseTheString {
    public static void  stringrec(String S,int N){
        String S_rev="";
        if(N==S.length()-1){
            System.out.print(S.charAt(N));
            return;

        }
        stringrec(S,N+1);
        System.out.print(S.charAt(N));
        return;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        int N=0;
        stringrec(S,N);

    }
}
