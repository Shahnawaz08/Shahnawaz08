package AdvanceDSA.DynamicProgramming;
/*
Problem Description
The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that he is able to rescue the princess.



Problem Constraints
1 <= M, N <= 500

-100 <= A[i] <= 10
 */

import java.util.Arrays;
import java.util.Scanner;

public class P4_DungeonPrincess {
    public static int calculateMinimumHP(int[][] A) {
        int M= A.length;
        int N=A[0].length;
        int [][] ps=new int[M+1][N+1];
        //putting infinity to the outer sides
        for(int i=0;i<=M;i++){
            ps[i][N]=Integer.MAX_VALUE;
        }
        for(int j=0;j<=N;j++){
            ps[M][j]=Integer.MAX_VALUE;
        }
        ps[M-1][N-1]=Math.max(1,1-A[M-1][N-1]);
        System.out.println(Arrays.deepToString(ps));
        for(int i=M-1;i>=0;i--){
            for(int j=N-1;j>=0;j--){
                if(i==M-1&&j==N-1){
                    continue;
                }
                ps[i][j]=Math.max(1,Math.min(ps[i][j+1],ps[i+1][j])-A[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(ps));
        return ps[0][0];

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int M=sc.nextInt();
        int N=sc.nextInt();
        int [][] A=new int[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                A[i][j]=sc.nextInt();
            }
        }
        int minHealth=calculateMinimumHP(A);
        System.out.println("Minimum health required is "+minHealth);
    }
}
