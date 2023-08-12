package AdvanceDSA.GraphProblems;
/*
Problem Description

A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.

Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.

All students who know each other are placed in one batch.

Strength of a batch is equal to sum of the strength of all the students in it.

Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.

Find the number of batches selected.

NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.
 */

import java.util.*;

public class P12_Batches {
    public static int sizeOfBatch(int i,int [] B,int [] visited,ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q=new LinkedList<>();
        int str=0;
        q.add(i);
        visited[i]=1;
        while (!q.isEmpty()){
            int node=q.poll();
            str=str+B[node-1];
            for(int nebour:adj.get(node)){
                if(visited[nebour]==-1){
                    q.add(nebour);
                    visited[nebour]=1;
                }
            }
        }
        return str;
    }

    public static int solve(int A, int[] B, int[][] C, int D) {
        //adjacency list;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=A;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<C.length;i++){
            int fst=C[i][0];
            int sec=C[i][1];
            adj.get(fst).add(sec);
            adj.get(sec).add(fst);
        }
        System.out.println(adj);
        int [] visited=new int[A+1];
        Arrays.fill(visited,-1);
        int count=0;
        for(int i=1;i<=A;i++){
            if(visited[i]==-1){
                int str=sizeOfBatch(i,B,visited,adj);
                if(str>=D){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       // System.out.println("Number of students is ");
        int A=sc.nextInt();
       // System.out.println("Enter strength of each ");
        int [] B=new int[A];
        for(int i=0;i<A;i++){
            B[i]=sc.nextInt();
        }
        //System.out.println("Number of edges followed by the edges");
        int M=sc.nextInt();
        int [][]C=new int[M][2];
        for(int i=0;i<M;i++){
            for(int j=0;j<2;j++){
                C[i][j]=sc.nextInt();
            }
        }
        //System.out.println("Minimum strength require");
        int D=sc.nextInt();
        int numberOfBatch=solve(A,B,C,D);
        System.out.println("Number of batches is "+numberOfBatch);

    }
}
//[[], [2], [6, 7], [], [13], [8, 13], [12], [10], [], [], [14], [], [], [14], []]
