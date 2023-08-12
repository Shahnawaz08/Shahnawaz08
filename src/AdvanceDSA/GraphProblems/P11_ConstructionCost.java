package AdvanceDSA.GraphProblems;
/*
Problem Description
Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.

Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.

NOTE: Return the answer modulo 109+7 as the answer can be large.



Problem Constraints
1 <= A <= 100000
0 <= C <= 100000
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 109



Input Format
First argument is an integer A.
Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and B[i][1] are connected by ith edge with weight B[i][2]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P11_ConstructionCost {
    static class pair{
        int node;
        int distance;
        pair(int distance,int node){
            this.node=node;
            this.distance=distance;
        }
    }
    public static int solve(int A, int[][] B) {
        //creating a adjacency list;
        ArrayList<ArrayList<ArrayList<Integer>>> adj=new ArrayList<>();
        for(int i=0;i<=A;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<B.length;i++){
            int fstNode=B[i][0];
            int secNode=B[i][1];
            int weight=B[i][2];
            ArrayList<Integer> nebour=new ArrayList<>();
            nebour.add(secNode);
            nebour.add(weight);
            adj.get(fstNode).add(nebour);
            //since it is a undirected graph soo we add from other node too
            ArrayList<Integer> nebour2=new ArrayList<>();
            nebour2.add(fstNode);
            nebour2.add(weight);
            adj.get(secNode).add(nebour2);
        }
        System.out.println(adj);
        //create a priority queue and it will take distance as comparing parameter
        PriorityQueue<pair> pq=new PriorityQueue<pair>((x,y)->x.distance-y.distance);
        int [] visited=new int[A+1];
        Arrays.fill(visited,0);
        long sum=0;
        pq.add(new pair(0, 1));
        while (!pq.isEmpty()){
            int wt=pq.peek().distance;
            int node=pq.peek().node;
            pq.poll();
            if(visited[node]==1) continue;
            visited[node]=1;
            sum=(sum+wt)%1000000007;
            for(ArrayList<Integer>nebour:adj.get(node)){
                int edw=nebour.get(1);
                int adjNode=nebour.get(0);
                if(visited[adjNode]==0){
                    pq.add(new pair(edw,adjNode));
                }
            }

        }
        return (int) sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of nodes");
        int A=sc.nextInt();
        System.out.println("Enter number of edges followed by fst node sec node and wt of edge b/n them");
        int M=sc.nextInt();
        int [][] B=new int[M][3];
        for(int i=0;i<M;i++){
            for(int j=0;j<3;j++){
                B[i][j]=sc.nextInt();
            }
        }
        int mst=solve(A,B);
        System.out.println("Minimum cost of constructing graph "+mst);
    }
}
