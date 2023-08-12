package AdvanceDSA.GraphProblems;

import java.util.Arrays;
import java.util.Scanner;

public class P13_FloydWarshallAlgorithm {
    public static void floydWarshall(int dist[][])
    {

        int i, j, k;
        int V=dist.length;



        /* Add all vertices one by one
           to the set of intermediate
           vertices.
          ---> Before start of an iteration,
               we have shortest
               distances between all pairs
               of vertices such that
               the shortest distances consider
               only the vertices in
               set {0, 1, 2, .. k-1} as
               intermediate vertices.
          ----> After the end of an iteration,
                vertex no. k is added
                to the set of intermediate
                vertices and the set
                becomes {0, 1, 2, .. k} */
        for (k = 0; k < V; k++) {
            // Pick all vertices as source one by one
            for (i = 0; i < V; i++) {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < V; j++) {
                    // If vertex k is on the shortest path
                    // from i to j, then update the value of
                    // dist[i][j]
                    if (dist[i][k] + dist[k][j]
                            < dist[i][j])
                        dist[i][j]
                                = dist[i][k] + dist[k][j];
                }
            }
        }
    }
    public static int[][] solve(int[][] A) {
        int N=A.length;
        int maxval=1000001;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(A[i][j]==-1){
                    A[i][j]=maxval;
                }
            }
        }
        floydWarshall(A);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(A[i][j]==maxval){
                    A[i][j]=-1;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of nodes");
        int N=sc.nextInt();
        int [][]A=new int[N][N];
        System.out.println("Enter distance of for i--j for each node");
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                A[i][j]=sc.nextInt();
            }
        }
        int [][]distOfEveryNodes= solve(A);
        for (int [] row:distOfEveryNodes) {
            System.out.println(Arrays.toString(row));
        }
    }
}
