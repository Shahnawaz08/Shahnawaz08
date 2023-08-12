package AdvanceDSA.Arrayproblems;

import java.util.Arrays;
import java.util.Scanner;
/*
Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.

Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

NOTE:

Rows are numbered from top to bottom, and columns are numbered from left to right.
Sum may be large, so return the answer mod 109 + 7.
 */

public class P9_SumOfSubarrays {
    public static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int N=A.length;
        int M=A[0].length;
        int [][] ps=new int[N][M];
        ps[0][0]=A[0][0];
        for (int i=1;i<N;i++){
            ps[i][0]=ps[i-1][0]+A[i][0];
        }
        for (int j=1;j<M;j++){
            ps[0][j]=ps[0][j-1]+A[0][j];
        }
        for (int i=1;i<N;i++){
            for(int j=1;j<M;j++){
                ps[i][j]=ps[i-1][j]+ps[i][j-1]-ps[i-1][j-1]+A[i][j];
            }
        }
        //System.out.println(Arrays.deepToString(ps));
        int size=B.length;
        int [] sol=new int[size];
        for(int i=0;i<size;i++) {
            int x1 = B[i] - 1;
            int y1 = C[i] - 1;
            int x2 = D[i] - 1;
            int y2 = E[i] - 1;
            if (x1 != 0 && y1 != 0) {
                sol[i] = ps[x2][y2] - ps[x1-1][y2] - ps[x2][y1 - 1] + ps[x1 - 1][y1 - 1];
            } else if (x1 == 0 && y1 == 0) {
                sol[i] = ps[x2][y2];
            } else if (y1 == 0) {
                sol[i] = ps[x2][y2] - ps[x1 - 1][y2];
            } else {
                sol[i] = ps[x2][y2] - ps[x2][y1 - 1];
            }
        }


        return sol;
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
        System.out.println("enter the  indices");
        int [] B=new int[2];
        B[0]=sc.nextInt();
        B[1]=sc.nextInt();
        int [] C=new int[2];
        C[0]=sc.nextInt();
        C[1]=sc.nextInt();
        int [] D=new int[2];
        D[0]=sc.nextInt();
        D[1]=sc.nextInt();
        int [] E=new int[2];
        E[0]=sc.nextInt();
        E[1]=sc.nextInt();
        int [] total=solve(arr,B,C,D,E);
        System.out.println(Arrays.toString(total));
    }
}
