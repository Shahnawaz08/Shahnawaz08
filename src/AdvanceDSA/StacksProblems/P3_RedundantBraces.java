package AdvanceDSA.StacksProblems;

import java.util.Scanner;
import java.util.Stack;

public class P3_RedundantBraces {
    public static int braces(String A) {
        int N=A.length();
        Stack<Character> S=new Stack<>();
        for(int i=0;i<N;i++){
            char ch=A.charAt(i);
            if(ch==')'){
                if(S.peek()=='('){
                    return 1;
                }
                else {
                    int cnt=0;
                    while (S.peek()!='('){
                        S.pop();
                        cnt++;
                    }
                    if(cnt==1){
                        return 1;
                    }
                    S.pop();
                }
            }
            else {
                S.push(ch);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int sol=braces(A);
        System.out.println("Solution of Expression is "+sol);

    }
}
