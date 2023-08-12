package Recursion_Problems;

import java.util.Scanner;

public class P7_KthSymbol {
    public static int solve(int A, int B) {
        int val=0;
        if(A==1&&B==1){
            return 0;
        }
        String s="202";

        System.out.println(s);


        return val;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int p=solve(A,B);
        System.out.println(p);
    }
}
