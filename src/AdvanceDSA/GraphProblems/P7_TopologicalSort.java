package AdvanceDSA.GraphProblems;

import java.util.*;
/*
Problem Description
Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

Return the topological ordering of the graph and if it doesn't exist then return an empty array.

If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.

Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.

NOTE:

There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 104

1 <= M <= min(100000,A*(A-1))

1 <= B[i][0], B[i][1] <= A
 */

public class P7_TopologicalSort {
    public static int[] solve(int A, int[][] B) {
        int [] sortedArray=new int[A];
        int idx=0;
        //creating a indegree array
        int [] indegree =new int[A+1];
        // creating an adjacency list;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=A;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<B.length;i++){
            adj.get(B[i][0]).add(B[i][1]);
            indegree[B[i][1]]++;
        }
        for(int i=0;i<=A;i++){
            Collections.sort(adj.get(i));
        }
        System.out.println(adj);
        System.out.println(Arrays.toString(indegree));
        PriorityQueue<Integer> q=new PriorityQueue<>();
        //Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=A;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int current_vtx=q.poll();
            sortedArray[idx]=current_vtx;//adding to the result
            idx++;
            for(int nebour:adj.get(current_vtx)){
                indegree[nebour]--;
                if(indegree[nebour]==0){
                    q.add(nebour);

                }
            }

        }
        return sortedArray;
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
       int [] topologicalOrdering=solve(A,B);
        System.out.println("topological ordering is "+Arrays.toString(topologicalOrdering));

    }
}
