package AdvanceDSA.Recursion;

import java.util.Scanner;

public class P7_AnotherSqyProb {
    public static int solve(int A) {
        if(A==1 ||A==2){
            return A;
        }
        if(A==0){
            return 1;
        }
        return A+solve(A-1)+solve(A-2)+solve(A-3);

    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int sum=solve(A);
        System.out.println(sum);
    }
}
