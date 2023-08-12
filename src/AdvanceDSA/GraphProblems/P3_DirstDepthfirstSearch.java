package AdvanceDSA.GraphProblems;

import java.util.*;

public class P3_DirstDepthfirstSearch {
    static boolean [] visited;
    public static boolean hasPath(ArrayList<ArrayList<Integer>>adj,int src,int dest){
        if(src==dest){
            return true;
        }
        for(int n:adj.get(src)){
            if(!visited[n]){
                visited[n]=true;
                boolean is=hasPath(adj,n,dest);
                if(is) return true;
            }
        }
        return false;
    }

    public static int solve(int[] A, final int B, final int C) {
        int N=A.length;
        //create a adjacency list
        ArrayList <ArrayList< Integer >> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<N+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=1;i<N;i++){
            adj.get(A[i]).add(i+1);
        }
        visited=new boolean[N+1];
        visited[C]=true;
        boolean path=hasPath(adj,C,B);
        if(path){
            return 1;
        }

        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of the Array followed by element of the array");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter ur destination");
        int B=sc.nextInt();
        System.out.println("Enter ur Starting Point");
        int C=sc.nextInt();
        int isPath=solve(A,B,C);
        if(isPath==1) System.out.println("So there is a path from "+C+" to "+B);
        else System.out.println("So there is no path from "+C+" to "+B);
    }
}
