package AdvanceDSA.GraphProblems;
/*
Problem Description
Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
Each cell can have three values:
The value 0 representing an empty cell.
The value 1 representing a fresh orange.
The value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom)
to a rotten orange becomes rotten. Return the minimum number of minutes that
must elapse until no cell has a fresh orange.
If this is impossible, return -1 instead.
Note: Your solution will run on multiple test cases. If you are using global
variables, make sure to clear them.



Problem Constraints
1 <= N, M <= 1000

0 <= A[i][j] <= 2
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P4_RottenOrange {
    static class pair
    {
        int i;
        int j;
        pair(int x,int y){
            i=x;
            j=y;
        }


    }
    public static boolean outSideGrid(int [][] A,int i,int j){
        int N=A.length;
        int M=A[0].length;
        if(i>=0&&i<N&&j>=0&&j<M){
            return false;
        }
        return true;
    }
    public static int solve(int[][] A) {
        int N=A.length;
        int M=A[0].length;
        int [][]dist=new int[N][M];
       // Arrays.fill(dist,Integer.MAX_VALUE);
        for(int [] temp:dist){
            Arrays.fill(temp,Integer.MAX_VALUE);
        }
       // System.out.println(Arrays.deepToString(dist));
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(A[i][j]==2){
                    dist[i][j]=0;
                    q.add(new pair(i,j));
                }
                if(A[i][j]==0){
                    dist[i][j]=0;
                }
            }
        }
//        for(pair n:q){
//            System.out.println(n.i+" "+n.j);
//        }
        //BFS
        int [] dx={0,-1,0,+1};
        int [] dy={1,0,-1,0};
        while (!q.isEmpty()){
            pair f=q.poll();
            for(int k=0;k<4;k++){
                int ni=f.i+dx[k];
                int nj=f.j+dy[k];
                if(outSideGrid(A,ni,nj)||A[ni][nj]==0){
                    continue;
                }
                if(A[ni][nj]==1){
                    A[ni][nj]=2;
                    dist[ni][nj]=1+dist[f.i][f.j];
                    q.add(new pair(ni,nj));
                }
            }

        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if(dist[i][j]>max){
                    max=dist[i][j];
                }
            }
        }
        if(max==Integer.MAX_VALUE) return -1;
        return max;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter dimension of the Matrix ");
        int N=sc.nextInt();
        int M=sc.nextInt();
        int [][]A=new int[N][M];
        System.out.println("Enter values which is filled in the matrix");
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j]=sc.nextInt();
            }
        }
       int timeToRottenAll=solve(A);
        if(timeToRottenAll==-1) System.out.println("some orange is safe ");
        else System.out.println("All oranges can be rotten in "+timeToRottenAll+" minutes");
    }
}
