package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class P14_AddTwoBinaryNo {
    public static String addBinary(String A, String B) {
        if(B.length()>A.length()){
            String temp=A;
            A=B;
            B=temp;
        }
        StringBuilder sb_A=new StringBuilder(A);
        StringBuilder sb_B=new StringBuilder(B);
        StringBuilder sb_revA=sb_A.reverse();
        StringBuilder sb_revB=sb_B.reverse();
        StringBuilder rev_sum=new StringBuilder();
        int carry=0;
        int i;
        for(i=0;i<B.length();i++){
            int a=sb_revA.charAt(i)-'0';
            int b=sb_revB.charAt(i)-'0';
            int no=(a+b+carry)%2;
            //System.out.println(no);
            rev_sum.append(no);
            carry=(a+b+carry)/2;
        }

        //After small string completed
        for(;i<A.length();i++){
            int a=sb_revA.charAt(i)-'0';
            int no=(a+carry)%2;
            rev_sum.append(no);
            carry=(a+carry)/2;

        }
        if(carry>0){
            rev_sum.append(carry);
        }



        return rev_sum.reverse().toString();



    }
    public static void main(String[] args) {
        //Question - Read N, followed by N lines, find out
        //the largest line based upon length
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        String sum=addBinary(A,B);
        System.out.println(sum);



    }
}
