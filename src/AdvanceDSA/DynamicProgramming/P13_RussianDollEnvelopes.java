package AdvanceDSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.

One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

Find the maximum number of envelopes you can put one inside other.



Problem Constraints
1 <= N <= 1000
1 <= A[i][0], A[i][1] <= 109
 */

public class P13_RussianDollEnvelopes {
    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            // Compare values according to columns
            public int compare(final int[] entry1,
                               final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  // End of function call sort().
    }
    public static int solve(int[][] A) {
        sortbyColumn(A,0);
       // System.out.println(Arrays.deepToString(A));
        for(int [] temp:A){
            System.out.println(Arrays.toString(temp));
        }
        int [] dp=new int[A.length];
        int omax=0;
        for(int i=0;i<dp.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(A[j][1]<A[i][1]&&A[j][0]<A[i][0]){
                    if(dp[j]>max){
                        max=dp[j];
                    }
                }
            }
            dp[i]=max+1;
            if(dp[i]>omax){
                omax=dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return omax;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [][]A=new int[N][2];
        for(int i=0;i<N;i++){
            for(int j=0;j<2;j++){
                A[i][j]=sc.nextInt();
            }
        }
        int res=solve(A);
        System.out.println(res);
    }
}
