package AdvanceDSA.StringPAtternMatching;
/*
Given two binary strings A and B, count how many cyclic shift of B
when taken XOR with A give 0.

NOTE: If there is a string, S0, S1, ... Sn-1 ,
then it is a cyclic shift is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.


Problem Constraints
1 ≤ length(A) = length(B) ≤ 105
 */

import java.util.Arrays;
import java.util.Scanner;

public class P1_CyclicPermutatiom {
    public static int[] getLpsArray(String S){
        int N=S.length();
        int [] LPS=new int[N];
        LPS[0]=0;
        for(int i=1;i<N;i++){
            int x=LPS[i-1];
            while (S.charAt(i)!=S.charAt(x)){
                if(x==0){
                    x=-1;
                    break;
                }
                x=LPS[x-1];
            }
            LPS[i]=x+1;
        }
        return LPS;

    }
    public static int solve(String A, String B) {
        String T=B+B;
        String P=A+"@";
        String S=P+T;
        System.out.println(T);
        System.out.println(P);
        int cnt=0;
        int [] LPS=getLpsArray(S);
        System.out.println(Arrays.toString(LPS));
        for(int i=0;i<S.length();i++){
            if(LPS[i]==A.length()){
                cnt++;
            }
        }
        if(A.equals(B)) {
            cnt = cnt - 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        int noOfshifts=solve(A,B);
        System.out.println("Number of cyclic shifts which prodeuces 0 when xor is "+noOfshifts);
    }
}
