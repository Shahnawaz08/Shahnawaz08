package general.easy;
/*
Given a number A. Return square root of the number if it is perfect square
otherwise return -1.
Problem Constraints

1 <= A <= 108
Input Format

First and the only argument is an integer A.
Output Format

Return an integer which is the square root of A if A is perfect square otherwise return -1.
 */

import java.util.Scanner;

public class P3_squareRootOfANumber {
    public static int solve(int A) {
        //int res= (int) Math.sqrt(A);
        int res=1;
        int s=1;
        int e=A;
        while (s<=e){
            long mid=s+(e-s)/2;
            if(mid*mid==A){
                return (int) mid;
            }
            else if(mid*mid>A){
                e= (int) (mid-1);
            } else {
                s= (int) (mid+1);
            }
        }
//        if(res*res==A){
//            return res;
//        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int res=solve(A);
        System.out.println(A);
        int chA=(int)'A';
        int cha=(int)'a';
        int ch0=(int)'0';
        System.out.println(chA);
        System.out.println(cha);
        System.out.println(ch0);
    }
}
