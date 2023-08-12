package AdvanceDSA.Arrayproblems;
/*
Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.


 */

import java.util.Arrays;
import java.util.Scanner;

public class P10_SumOfSubmatrix {
    public static int solve(int[][] A) {
        int sum=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                sum+=(i+1)*(j+1)*(A.length-i)*(A[0].length-j)*A[i][j];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int [][] arr=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        int total_sum=solve(arr);
        System.out.println((total_sum));
    }
}
