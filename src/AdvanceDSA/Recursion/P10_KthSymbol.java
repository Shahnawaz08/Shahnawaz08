package AdvanceDSA.Recursion;
/*
On the first row, we write a 0. Now in every subsequent row,
we look at the previous row and replace each occurrence of 0 with 01,
and each occurrence of 1 with 10.
Given row number A and index B, return the Bth indexed symbol in row A.
(The values of B are 1-indexed.).
Problem Constraints
1 <= A <= 20
1 <= B <= 2A - 1
 */

import java.util.ArrayList;
import java.util.Scanner;

public class P10_KthSymbol {
    public static void helper(ArrayList<Integer> arr,int A){
        if(A==1){
            arr.add(0);
            return;
        }
        helper(arr,A-1);

        int len=arr.size();
        for(int i=0;i<len;i++){
            arr.add(1-arr.get(i));

        }

    }

    public static int solve(int A, int B) {
        ArrayList<Integer> S=new ArrayList<>();
        helper(S,A);
        System.out.println(S);
        return S.get(B-1);
    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int symbol=solve(A,B);
        System.out.println(symbol);

    }
}
