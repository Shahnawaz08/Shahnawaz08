package AdvanceDSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;
/*
Problem Description
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
Also given an integer C which represents knapsack capacity.
Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).



Problem Constraints
1 <= N <= 500

1 <= C, B[i] <= 106

1 <= A[i] <= 50
 */

public class P8_0_1_Knapsack_II {
    public static int solve(int[] A, int[] B, int C) {
        int i, w;
        int[][] K = new int[2][C + 1];
        int n=A.length;

        // We know we are always using the current row or
        // the previous row of the array/vector . Thereby we
        // can improve it further by using a 2D array but
        // with only 2 rows i%2 will be giving the index
        // inside the bounds of 2d array K
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= C; w++) {
                if (i == 0 || w == 0)
                    K[i % 2][w] = 0;
                else if (B[i - 1] <= w)
                    K[i % 2][w] = Math.max(A[i - 1] + K[(i - 1) % 2][w - B[i - 1]], K[(i - 1) % 2][w]);
                else
                    K[i % 2][w] = K[(i - 1) % 2][w];
            }
        }
        return K[n % 2][C];

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array ");
        int N=sc.nextInt();
        int [] A=new int[N];
        int [] B=new int[N];
        System.out.println("Enter values of the the elements");
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter weight of the the elements");
        for(int i=0;i<N;i++){
            B[i]=sc.nextInt();
        }
        System.out.println("Enter capacity of the knapsack");
        int C=sc.nextInt();
        int maxval=solve(A,B,C);
        System.out.println("Maximum profile that can be achieved is "+maxval);
    }
}

