package AdvanceDSA.GraphProblems;
/*
Problem Description
Given a undirected graph having A nodes. A matrix B of size M x 2 is given
which represents the edges such that there is an edge between B[i][0] and B[i][1].
Find whether the given graph is bipartite or not.

A graph is bipartite if we can split it's set of nodes into two independent
subsets A and B such that every edge in the graph has one node in A and another
node in B

Note:

There are no self-loops in the graph.
No multiple edges between two pair of vertices.
The graph may or may not be connected.
Nodes are Numbered from 0 to A-1.
Your solution will run on multiple testcases.
If you are using global variables make sure to clear them.



Problem Constraints
1 <= A <= 100000
1 <= M <= min(A*(A-1)/2,200000)
0 <= B[i][0],B[i][1] < A
 */

import java.util.*;

public class P5_CheckBipartiteGraph {
    public static boolean bipartiteBfs(ArrayList<ArrayList<Integer>> adj,int i,int [] colour){
        Queue<Integer> q=new LinkedList<>();
//
        colour[i]=1;
        q.add(i);
        while (!q.isEmpty()){
            int ver=q.poll();
            for(int nebour: adj.get(ver)){
                //if nebour is not colour we colour it is opposite colour of current vertex
                if(colour[nebour]==-1){
                    colour[nebour]=1-colour[ver];
                    q.add(nebour);
                }
                //if nebour is already colour and it is same so bipartite is not possible
                else if (colour[nebour]==colour[ver]){
                    return false;
                }
            }
        }
        return true;
    }
    public static int solve(int A, int[][] B) {
        //create an adjacency list
        ArrayList<ArrayList<Integer>> adj =new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<A;i++){
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
        int [] colour=new int[A];
        Arrays.fill(colour,-1);
        //since graph can be disconnected so we have to run bipartite for
        //every component
        for(int i=0;i<A;i++){
            if(colour[i]==-1){
                if(!bipartiteBfs(adj,i,colour)){
                    return 0;
                }
            }
        }

        return 1;
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
        int isbipartite=solve(A,B);
        if(isbipartite==1) System.out.println("Graph is bipartite");
        else System.out.println("Geraph is not bipartite");

    }
}
