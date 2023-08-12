package AdvanceDSA.DynamicProgramming;
/*
Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Note: You can choose more than 2 numbers.



Problem Constraints

1 <= N <= 20000
1 <= A[i] <= 2000
 */

import java.util.Arrays;
import java.util.Scanner;

public class P6_MaxSumWithoutAdjacentElement {
    //public static int adjacent()
    public static int adjacent(int[][] A) {
        int len=A[0].length;
        if(len==1){
            return Math.max(A[0][0],A[1][0]);
        }
        int [] ps=new int[len];
        ps[0]=Math.max(A[0][0],A[1][0]);

        //System.out.println(A[1][0]+" "+A[1][1]);
        ps[1]=Math.max(A[0][1],A[1][1]);
        for(int i=2;i<len;i++){
            ps[i]=ps[i-2]+Math.max(A[1][i],A[0][i]);
        }
        //16 5 54 55 36 82 61 77 66 61 31 30 36 70 9 37 1 11 68 14
        System.out.println(Arrays.toString(ps));
        int max=0;
        for(int i=0;i<ps.length;i++){
            max=Math.max(ps[i],max);
        }
        return max;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [][] A=new int[2][N];
        for(int i=0;i<2;i++){
            for(int j=0;j<N;j++){
                A[i][j]=sc.nextInt();
            }
        }
        int maxsum=adjacent(A);
        System.out.println("Maximum sum "+maxsum);
    }
}
