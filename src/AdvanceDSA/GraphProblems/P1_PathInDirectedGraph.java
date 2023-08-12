package AdvanceDSA.GraphProblems;
/*
Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node

B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.

NOTE:

There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 105

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A
 */

import java.util.*;

public class P1_PathInDirectedGraph {
    public static int solve(int A, int[][] B) {
        HashMap<Integer, ArrayList<Integer>> graph=new HashMap<>();
        for(int i=0;i<B.length;i++){
            if(!graph.containsKey(B[i][0])){
                ArrayList<Integer> nebur=new ArrayList<>();
                nebur.add(B[i][1]);
                graph.put(B[i][0],nebur);
            }
            else {
                graph.get(B[i][0]).add(B[i][1]);
            }
        }
        //System.out.println(graph);
        boolean [] visited=new boolean[A+1];
        Arrays.fill(visited,false);
        Queue<Integer> que=new LinkedList<>();
        que.add(1);
        visited[1]=true;
        while (!que.isEmpty()){
            int f=que.peek();
            //System.out.println(f);
            que.remove();visited[f]=true;
            ArrayList<Integer> nebour=graph.get(f);
            if(nebour!=null) {
                for (int n : nebour) {
                    if (!visited[n]) {
                        que.add(n);
                        visited[n] = true;
                    }
                }
            }
            //System.out.println("Hii");
        }
        //System.out.println(Arrays.toString(visited));
        if(visited[A]){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Number of nodes");
        int A=sc.nextInt();
        System.out.println("Number of edges");
        int M= sc.nextInt();
        int [][]B=new int[M][2];
        for(int i=0;i<M;i++){
            for(int j=0;j<2;j++){
                B[i][j]=sc.nextInt();
            }
        }
        int ispath=solve(A,B);
        if(ispath==1) System.out.println("There is a path");
        else System.out.println("There is no path");
    }
}
