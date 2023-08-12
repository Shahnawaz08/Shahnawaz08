package AdvanceDSA.GraphProblems;
/*
Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form of matrix B of size M x 2 where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.

Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:

The cycle must contain atleast three nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints

1 <= A, M <= 3*105

1 <= B[i][0], B[i][1] <= A
 */

import java.util.*;

public class P6_CycleInUndirectedGraph {
    public static boolean checkCycleBfs(ArrayList<ArrayList<Integer>> adj,int i,int [] visited){
        Queue<Integer> q=new LinkedList<>();
        visited[i]=1;
        q.add(i);
        while (!q.isEmpty()){
            int currentVert=q.poll();
           // System.out.println("current idx "+currentVert+" nebours "+adj.get(currentVert));
            int cnt=0;
            for(int nbr:adj.get(currentVert)){
                if(visited[nbr]==1){
                    cnt++;
                    if(cnt==2){
                        //System.out.println("count 2");
                        return true;
                    }
                }
                else {
                    visited[nbr]=1;
                    q.add(nbr);
                }
            }
        }
        return false;
    }
    public static int solve(int A, int[][] B) {
        //create an adjacency list
        ArrayList<ArrayList<Integer>> adj =new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=A;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<B.length;i++){
            ArrayList<Integer> nebour1=adj.get(B[i][0]);
            ArrayList<Integer> nebour2=adj.get(B[i][1]);
            nebour1.add(B[i][1]);
            nebour2.add(B[i][0]);
        }
        System.out.println(adj);
        //creating a colour array
        int [] visited=new int[A+1];
        Arrays.fill(visited,-1);
        for(int i=1;i<=A;i++){
            if(visited[i]==-1){
                if(checkCycleBfs(adj,i,visited)){
                    return 1;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Number of nodes is ");
        int A=sc.nextInt();
        System.out.println("Number of edges followed by the edges");
        int M=sc.nextInt();
        int [][]B=new int[M][2];
        for(int i=0;i<M;i++){
            for(int j=0;j<2;j++){
                B[i][j]=sc.nextInt();
            }
        }
        int havCycle=solve(A,B);
        if(havCycle==1) System.out.println("Graph is have cycle ");
        else System.out.println("Graph doesn't have cycle ");

    }
}
