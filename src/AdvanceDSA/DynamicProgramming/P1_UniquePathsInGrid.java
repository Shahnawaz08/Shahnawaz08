package AdvanceDSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;
/*
Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.


 */

public class P1_UniquePathsInGrid {
    public static int uniquePathsWithObstacles(int[][] A) {
        if(A[0][0]==0){
            A[0][0]=1;
        }else{
            A[0][0]=0;
        }
        int prev=A[0][0];
        for(int i=1;i<A.length;i++){
            if(A[i][0]==1){
                A[i][0]=0;
            }
            else {
                A[i][0]=prev;
            }
            prev=A[i][0];
        }
        prev=A[0][0];
        for(int i=1;i<A[0].length;i++){
            if(A[0][i]==1){
                A[0][i]=0;
            }
            else {
                A[0][i]=prev;
            }
            prev=A[0][i];
        }
        if(A.length>1&&A[0].length>1){
            for(int i=1;i<A.length;i++){
                for(int j=1;j<A[0].length;j++){
                    if(A[i][j]!=1){
                        A[i][j]=A[i-1][j]+A[i][j-1];
                    }else{
                        A[i][j]=0;
                    }
                }
            }
        }
        return A[A.length-1][A[0].length-1];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int [][] A=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j]=sc.nextInt();
            }
        }
        int noOfPath=uniquePathsWithObstacles(A);
        System.out.println(Arrays.deepToString(A));
        System.out.println(noOfPath);
    }
}
