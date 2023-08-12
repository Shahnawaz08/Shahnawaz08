package modularArithmetic;
/*
Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.
 */

import java.util.Scanner;

public class P2_ABModulo {
    public static int solve(int A,int B){
        if(A>B){
            int temp=B;
            B=A;
            A=temp;
        }
        /*
        int num=A;
        A : 106978
        B : 4487506
        if we choose the larger one we dont get the actual ans
         */
        int num=B;
        while (num>1){
            if(A%num==B%num){
                break;
            }
            num--;
        }
        return num;
    }
    public static int solve1(int A,int B){
        return Math.abs(A-B);
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int N=solve(A,B);
        int N1=solve1(A,B);
        System.out.println(N);
        System.out.println(N1);
    }
}
