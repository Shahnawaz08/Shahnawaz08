package modularArithmetic;

import java.util.Scanner;

public class P1_divisibleBy8 {
    public static int solve(String A) {
        int N=A.length();
        StringBuilder sb=new StringBuilder();
        String S="";
        if(N>3){
            sb.append(A.charAt(N-3));
            sb.append(A.charAt(N-2));
            sb.append(A.charAt(N-1));
            S=sb.toString();
        }

        else{
            S=A;
        }
        int num=0;
        int pos=1;
        for(int i=S.length()-1;i>=0;i--){
            int temp=S.charAt(i)-'0';
            num+=temp*pos;
            pos*=10;
        }
        System.out.println(num);
        int isdiv=0;
        if(num%8==0){
            isdiv=1;
        }

        //char c='1';

        //System.out.println((int)(c-'0'));
        //System.out.println(sb);

        //System.out.println(S);
        return isdiv;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n= solve(s);
        if(n==1){
            System.out.println("it is divided by 8 " +n);
        }
        else{
            System.out.println("it is not divided by 8 "+n);
        }

    }
}
