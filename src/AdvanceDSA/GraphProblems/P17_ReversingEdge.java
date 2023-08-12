package AdvanceDSA.GraphProblems;

import java.util.*;

public class P17_ReversingEdge {
    static class  pairN{
        int vertex;
        int dist;
        pairN(int a,int d){
            vertex=a;
            dist=d;
        }
    }
    public static int[] solve(int A, int[][] B, int C) {
        int [] dist=new int[A+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        ArrayList<ArrayList<pairN>> adj=new ArrayList<>();
        for(int i=0;i<=A;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] temp:B){
            adj.get(temp[0]).add(new pairN(temp[1],temp[2]));
        }

        Queue<Integer> q=new LinkedList<>();
        q.add(C);
        dist[C]=0;
        while (!q.isEmpty()){
            int node=q.poll();
            for(pairN p:adj.get(node)){
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
    public static int reverseEdges(int A, int[][] B) {
        int M=B.length;
        int [][] C=new int[M+M][3];
        for(int i=0;i<M;i++){
            int fst=B[i][0];
            int sec=B[i][1];
            //adding the already present edge
            C[i][0]=fst;
            C[i][1]=sec;
            C[i][2]=0;
            //adding the revers edge
            C[M+i][0]=sec;
            C[M+i][1]=fst;
            C[M+i][2]=1;

        }
        int [] dist=solve(A,C,1);
        ;
        if(dist[A]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[A];
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
        int minNoOfEdge=reverseEdges(A,B);
        System.out.println("Minimun Number of Edges "+minNoOfEdge);



    }
}
