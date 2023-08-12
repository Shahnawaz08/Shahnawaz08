package StackAndQueues;

import java.util.Scanner;

public class P2_Balanced_parantheses {
    public static int solve(String A) {
        //int isvalid = 1;
        int N = A.length();
        char[] stack = new char[N];
        int index=-1;
        for(int i=0;i<N;i++){
            char ch=A.charAt(i);
            if(ch=='('||ch=='{'||ch=='[') {
                index++;
                stack[index] = ch;
                System.out.println(stack[index]+" "+index);
            }
            else if(ch==')'&& index!=-1){
                if(stack[index]=='('){
                    index--;
                    continue;
                }
                return 0;
            }
            else if(ch=='}'&& index!=-1){
                if(stack[index]=='{'){
                    index--;
                    continue;
                }
                return 0;
            }
            else if(ch==']'&& index!=-1){
                System.out.println(stack[index]+" "+index);
                if(stack[index]=='['){
                    index--;
                    continue;
                }
                System.out.println("hi");
                return 0;
            }
            else {
                return 0;
            }
        }
        System.out.println("i am outside"+index);
        if (index!=-1){
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int valid = solve(S);
        if (valid == 1) {
            System.out.println("valid expression");
        } else {
            System.out.println("Invalid expression");
        }
    }
}

