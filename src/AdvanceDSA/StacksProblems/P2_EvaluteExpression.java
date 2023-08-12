package AdvanceDSA.StacksProblems;

import java.util.Scanner;
import java.util.Stack;

public class P2_EvaluteExpression {
    public static int evalRPN(String[] A) {
        int N=A.length;
        Stack <Integer> s=new Stack <Integer>();
        for(int i=0;i<N;i++){
            String ch=A[i];
            ////System.out.println(" charcter at that positon "+ch);
            // System.out.println("check equivalance "+ch.equals("+"));
            if(ch.equals("+")||ch.equals("-")||ch.equals("*")||ch.equals("/")){
                // System.out.println("inside evaluated value is "+ch);
                int b=s.pop();
                int a=s.pop();
                if(ch.equals("+")){
                    int sol=a+b;
                    s.push(sol);
                    //System.out.println(s.peek());
                }
                else if(ch.equals("-")){
                    int sol=a-b;
                    s.push(sol);
                }
                else if(ch.equals("*")){
                    int sol=a*b;
                    s.push(sol);
                }
                else{
                    int sol=a/b;
                    s.push(sol);
                }
            }
            else{

                int op=Integer.parseInt(ch);
                s.push(op);
            }
        }
        //System.out.println(s.peek());
        return s.pop();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        String [] A=new String[N];
        for(int i=0;i<N;i++){
            A[i]=sc.next();
        }
        int sol=evalRPN(A);
        System.out.println("Solution of Expression is "+sol);

    }
}
