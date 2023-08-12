package AdvanceDSA.Recursion;
/*
Given a number A, check if it is a magic number or not.

A number is said to be a magic number if the sum of its digits is calculated till a single digit recursively by adding the sum of the digits after every addition.
If the single digit comes out to be 1, then the number is a magic number.
 */

import java.util.Scanner;

public class P2_IsMagic {

    //Recursive method
    public static int recsum(int A){
        if(A==0){
            return 0;
        }
        int sum=A%10+recsum(A/10);
        if(sum>9){
            sum=sum%10+recsum(sum/10);
        }
        return  sum;
    }

    public static int solve(int A){
        int sum=recsum(A);
        //System.out.println("hii");
        if(sum==1){
            return 1;
        }
        return 0;
    }
    //iterattive method
    public static int solveittr(int A){
        while (A>9){
            int sum=0;
            while (A!=0){
                sum=sum+A%10;
                A=A/10;
            }
            A=sum;
        }
        if(A==1){
            return 1;
        }
        return 0;
    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int sum=solve(A);
        System.out.println(sum);
    }
}
