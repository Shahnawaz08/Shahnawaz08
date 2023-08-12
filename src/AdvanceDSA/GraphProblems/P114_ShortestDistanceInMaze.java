package AdvanceDSA.GraphProblems;
/*
Problem Description
Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.

1 represents a wall in a matrix and 0 represents an empty location in a wall.

There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.

Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.

Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.



Problem Constraints
2 <= N, M <= 100

0 <= A[i] <= 1

0 <= B[i][0], C[i][0] < N

0 <= B[i][1], C[i][1] < M
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P114_ShortestDistanceInMaze {
    static class triplet{
        int dist;
        int row;
        int col;
        triplet(int d,int r,int c){
            dist=d;
            row=r;
            col=c;
        }
    }
    public static boolean validPos(int[][] A,int r,int c){
        int n=A.length;
        int m=A[0].length;
        if(r<0 ||r>=n ||c<0 ||c>=m){
            return false;
        }
        return true;
    }
    public static int solve(int[][] A, int[] B, int[] C) {
        // Check if starting and destination is same
        if(B[0]==C[0]&&B[1]==C[1])  return 0;
        //create distance matrix;
        int n=A.length;
        int m=A[0].length;
        int [][] dist=new int[n][m];
        for(int [] temp:dist){
            Arrays.fill(temp,Integer.MAX_VALUE);
        }
        dist[B[0]][B[1]]=0;

        //create a queue to traverse just like dikstra but here we don't need priority queue
        //coz all the next distance is at 1 only
        Queue<triplet> q=new LinkedList<>();
        q.add(new triplet(0,B[0],B[1]));
        int []dr={-1,0,1,0};
        int []dc={0,1,0,-1};
        while (!q.isEmpty()){
            triplet loc=q.poll();
            int dis=loc.dist;
            int r=loc.row;
            int c=loc.col;
            //lets travers in all the direction
            for(int i=0;i<4;i++) {
                int newr=r+dr[i];
                int newc=c+dc[i];
                if (validPos(A, newr, newc) &&A[newr][newc]==0) {
//                    if(newr==C[0]&&newc==C[1]){
//                        int nextr=newr+dr[i];
//                        int nextc=newc+dc[i];
//                        if(!validPos(A,nextr,nextc)||A[nextr][nextc]==1){
//                            return dis+1;
//                        }
//                    }
//                    if(dis+1<dist[newr][newc]){
//                        dist[newr][newc]=dis+1;
//                        q.add(new triplet(dis+1,newr,newc));
//                    }
                    int extradist=1;
                    while (validPos(A, newr, newc) &&A[newr][newc]==0) {
                        extradist++;
                        newr=newr+dr[i];
                        newc=newc+dc[i];
                    }
                    newr=newr-dr[i];
                    newc=newc-dc[i];
                    extradist--;
                    if(newr==C[0]&&newc==C[1]){
                        return dis+extradist;
                    }
                    if(dis+extradist<dist[newr][newc]){
                        dist[newr][newc]=dis+extradist;
                        q.add(new triplet(dist[newr][newc],newr,newc));
                    }

                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter dimension of maze");
        int N=sc.nextInt();
        int M=sc.nextInt();
        int [][]A=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j]=sc.nextInt();
            }
        }
        System.out.println("enter starting position");
        int [] B=new int[2];
        for(int i=0;i<2;i++){
            B[i]=sc.nextInt();
        }
        System.out.println("enter destination position");
        int [] C=new int[2];
        for(int i=0;i<2;i++){
            C[i]=sc.nextInt();
        }
        int mindist=solve(A,B,C);
        if(mindist==-1) System.out.println("Ball can't stop at destination");
        else System.out.println("Ball take "+mindist+" to reach the destination");
    }
}
