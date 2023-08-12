package AdvanceDSA.BitManipulation;
/*
Given two binary strings, return their sum (also a binary string).
Example:

a = "100"

b = "11"
Return a + b = "111".
 */

import java.util.Scanner;

public class P5_AddBinaryString {
    public static String addBinary(String A, String B) {
        StringBuilder S=new StringBuilder();
        if(A.length()<B.length()){
            String temp=A;
            A=B;
            B=temp;
        }
        int carry=0;
        //S.append(1);
        //S.insert(0,9);
        int N=B.length();
        int M=A.length();
        for (int i=0;i<N;i++){
            int fst=A.charAt(M-i-1)-'0';
            int sec=B.charAt(N-i-1)-'0';
            int no=fst^sec^carry;
            carry=fst&carry | sec&carry |fst&sec;
            S.insert(0,no);
        }
        int rem=M-N;
        for(int i=rem-1;i>=0;i--){
            int fst=A.charAt(i)-'0';
            int no=fst^carry;
            carry=carry&fst;
            S.insert(0,no);
        }
        if(carry==1){
            S.insert(0,carry);
        }

        //System.out.println(S);
        String sum=S.toString();
        return sum;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        String sum=addBinary(A,B);
        System.out.println(sum);

    }
}
