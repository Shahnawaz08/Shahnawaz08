package StackAndQueues;

import java.util.Scanner;

public class P1_Balanced_Parantheses {
    public static int solve(String A) {
        int isvalid=1;
        int N=A.length();
        char [] stack=new char[N];
        int index=-1;
        for(int i=0;i<N;i++){
            if(A.charAt(i)=='('){
                index++;
                stack[index]='(';
            }
            if (A.charAt(i) == ')') {
                if(index==-1){
                    return 0;
                }
                index--;
            }
        }
        if(index!=-1){
            return 0;
        }
        return isvalid;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        int valid=solve(S);
        if(valid==1){
            System.out.println("valid expression");
        }
        else{
            System.out.println("Invalid expression");
        }

    }
}
