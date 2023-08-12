package AdvanceDSA.StacksProblems;

import java.util.Scanner;
import java.util.Stack;

public class P1_BalancedParanthesis {
    public static int solve(String A) {
        Stack<Character> S=new Stack<>();
        int N=A.length();

        for(int i=0;i<N;i++){
            char ch=A.charAt(i);
            if(ch=='{'||ch=='('||ch=='['){
                S.push(ch);
            }
            else if(!S.isEmpty()&&(ch == '}' && S.peek() == '{' || ch == ')' && S.peek() == '(' || ch == ']' && S.peek() == '[')) {

                    S.pop();
            }
            else {
               return 0;
            }
        }
        if(!S.isEmpty()){
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        int isvalid=solve(S);
        if(isvalid==1){
            System.out.println("Vailid Paranthesis");
        }else {
            System.out.println("Invailid paranthesis");
        }
    }
}
