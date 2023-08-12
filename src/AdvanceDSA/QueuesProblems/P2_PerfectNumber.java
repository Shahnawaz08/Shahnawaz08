package AdvanceDSA.QueuesProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
Given an integer A, you have to find the Ath Perfect Number.
A Perfect Number has the following properties:
It comprises only 1 and 2.
The number of digits in a Perfect number is even.
It is a palindrome number.
For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.

Problem Constraints
1 <= A <= 100000
 */

public class P2_PerfectNumber {
    public static String solve(int A) {

        StringBuilder S=new StringBuilder();
//        S.insert(0,pno);
//
//        System.out.println(S);
//        S.insert(S.length()/2,"22");
//        System.out.println(S);
        if(A==1){
            return "11";
        }
        if(A==2){
            return "22";
        }
        Queue<String>Q=new LinkedList<>();
        String pno="";
        Q.add("11");
        Q.add("22");
        int cnt=2;
        while (true){
            String s=Q.remove();
            StringBuilder sb=new StringBuilder(s);
            sb.insert(sb.length()/2,"11");
            pno=sb.toString();
            Q.add(pno);
            cnt++;
            if(cnt==A) break;
            sb=new StringBuilder(s);
            sb.insert(sb.length()/2,"22");
            pno=sb.toString();
            Q.add(pno);
            cnt++;
            if(cnt==A) break;
        }
        return pno;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        String pftNo=solve(A);
        System.out.println("Perfect number is "+pftNo);
    }
}
