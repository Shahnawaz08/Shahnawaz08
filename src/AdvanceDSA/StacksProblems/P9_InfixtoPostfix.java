package AdvanceDSA.StacksProblems;
/*
Problem Description
Given string A denoting an infix expression. Convert the infix expression into a postfix expression.

String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.

Find and return the postfix expression of A.

NOTE:

^ has the highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.
 */

import java.util.Scanner;
import java.util.Stack;

public class P9_InfixtoPostfix {
    static int Precedence (char c) {
        if (c == '^') {
            return 3;
        }
        else if (c == '/' || c == '*') {
            return 2;
        }
        else if (c == '+' || c == '-') {
            return 1;
        }
        else {
            return 0;
        }
    }
    static boolean isOperand (char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }
        public static String solve(String A){
        StringBuilder postFix=new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i<A.length(); ++i) {
            char c = A.charAt(i);
            if (isOperand(c)) {
                //postFix += c;
                postFix.append(c);
            }
            else if (c == '(') {
                st.push(c);
            }
            else if (c == ')') {
                while (st.peek() != '(') {
                    //postFix += st.pop();
                    postFix.append(st.pop());
                }
                st.pop();
            }
            else  {
                while (!st.isEmpty() && Precedence(c) <= Precedence(st.peek())) {
                    //postFix += st.pop();
                    postFix.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            //postFix += st.pop();
            postFix.append(st.pop());
        }

        return postFix.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String postfix=solve(A);
        System.out.println("post fix expression of "+A+" is "+postfix);

    }
}
