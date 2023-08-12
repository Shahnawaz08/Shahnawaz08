package AdvanceDSA.GraphProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P15_CycleInDirectedGraph {
    public static boolean hasCycle(ArrayList<ArrayList<Integer>> adj,int node,int [] visited,boolean [] stackArray){
        if(visited[node]==1&&!stackArray[node]){ //if element is already visited and not present in stack
            return false;
        }
        if(visited[node]==1 && stackArray[node]){
            return true;
        }
       // recursive case
        visited[node]=1;
        stackArray[node]=true;
        for(int i:adj.get(node)){
            if(visited[i]==1&&stackArray[i]){
                return true;
            }
            else {
                boolean cycle = hasCycle(adj, i, visited, stackArray);
                if (cycle) {
                    return true;
                }
            }
        }
        stackArray[node]=false;
        return false;
    }
    public static int solve(int A, int[][] B) {
        //create a adjancency list
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=A;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<B.length;i++){
            int st=B[i][0];
            int end=B[i][1];
            adj.get(st).add(end);
        }
        //System.out.println(adj);
        //create a visited array
        int [] visited=new int[A+1];
        Arrays.fill(visited,-1);
        //creating a stack_Array
        boolean [] stack_Array=new boolean[A+1];
        Arrays.fill(stack_Array,false);
        //traverse through all the unvisited node
        for(int i=1;i<=A;i++){
            if(visited[i]==-1){
                if(hasCycle(adj,i,visited,stack_Array)){
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
