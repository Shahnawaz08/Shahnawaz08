package AdvanceDSA.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRA
 */

public class P1_Permutation {
    static int [][] twoDArray;
    static int row=0;
    public static int fact(int n){
        int fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }
    public static void permuteHelper(int[] input, int i, int n){
        //base case
        if(i==input.length){
            int [] temp=input.clone();
            twoDArray[row]=temp;
            row++;
            return;
        }
        //rec case
        for(int j=i;j<n;j++){
            //swap a[i],a[j];
            int temp=input[i];
            input[i]=input[j];
            input[j]=temp;
            permuteHelper(input,i+1,n);
            //swap a[i],a[j];
            temp=input[i];
            input[i]=input[j];
            input[j]=temp;

        }

    }

    public static int[][] permute(int[] A) {
        int no=A.length;
        //no of rows is equal to number of permutation
        int noOfRows=fact(no);
        twoDArray=new int[noOfRows][];
        ArrayList<Integer> arr=new ArrayList<>();
        permuteHelper(A,0,A.length);
        return twoDArray;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int [][] res=permute(A);
        System.out.println(Arrays.deepToString(res));
    }
}
