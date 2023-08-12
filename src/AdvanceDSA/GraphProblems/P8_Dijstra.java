package AdvanceDSA.GraphProblems;

import java.util.*;
/*
Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.

You have to find an integer array D of size A such that:

=> D[i] : Shortest distance form the C node to node i.

=> If node i is not reachable from C then -1.

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.



Problem Constraints
1 <= A <= 1e5

0 <= B[i][0],B[i][1] < A

0 <= B[i][2] <= 1e3

0 <= C < A
 */

public class P8_Dijstra {
   static class  pairNode{
        int vertex;
        int dist;
        pairNode(int a,int d){
            vertex=a;
            dist=d;
        }
    }
    public static int[] solve(int A, int[][] B, int C) {
        int [] dist=new int[A];
        Arrays.fill(dist,Integer.MAX_VALUE);
        ArrayList<ArrayList<pairNode>> adj=new ArrayList<>();
        for(int i=0;i<A;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] temp:B){
            adj.get(temp[0]).add(new pairNode(temp[1],temp[2]));
            adj.get(temp[1]).add(new pairNode(temp[0],temp[2]));
        }
//        for(int i=0;i<A;i++){
//            ArrayList<pairNode> arr=adj.get(i);
//            for(pairNode p:arr){
//                System.out.println("There is an edge from "+i+" "+p.vertex+" with weight "+p.dist);
//            }
//
//        }
        Queue<Integer> q=new LinkedList<>();
        q.add(C);
        dist[C]=0;
        while (!q.isEmpty()){
            int node=q.poll();
            for(pairNode p:adj.get(node)){
                int current_distanceOfNebour=dist[p.vertex];
                int distanceThroughParent=dist[node]+p.dist;
                //if distance from this path is smaller then we put the new distance
                //if so then we add the node in queue so that we can change the distance of child node of
                //current node if they are closer through this path
                if(current_distanceOfNebour>distanceThroughParent){
                    dist[p.vertex]=dist[node]+p.dist;
                    q.add(p.vertex);
                }
            }
        }
        //if still distance is infinite so it is unreachable from the starting node
        for(int i=0;i<A;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number odf the nodes");
        int A=sc.nextInt();
        System.out.println("ENter Starting nodes");
        int C=sc.nextInt();
        System.out.println("Enter number of edges");
        int M= sc.nextInt();
        int [][] B=new int[M][3];
        for(int i=0;i<M;i++){
                B[i][0]=sc.nextInt();
                B[i][1]=sc.nextInt();
                B[i][2]=sc.nextInt();

        }
        int [] minDist=solve(A,B,C);
        System.out.println(Arrays.toString(minDist));
    }
}
