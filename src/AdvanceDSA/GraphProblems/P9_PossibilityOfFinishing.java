package AdvanceDSA.GraphProblems;
/*
There are a total of A courses you have to take, labeled from 1 to A.

Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].

So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.



Problem Constraints
1 <= A <= 6*104

1 <= length(B) = length(C) <= 105

1 <= B[i], C[i] <= A
 */

import java.lang.reflect.Array;
import java.util.*;

public class P9_PossibilityOfFinishing {
    public static boolean haveCycle(ArrayList<ArrayList<Integer>> adj,int i,int [] visited ,boolean [] stackArray){
        //recursive case :
        visited[i]=1;
        stackArray[i]=true;
        for(int nebour:adj.get(i)){
            if(visited[nebour]==1){
                if(stackArray[nebour]){
                    return true;
                }
            }
            else{

                boolean istrue= haveCycle(adj,nebour,visited,stackArray);
                if(istrue) return true;
            }
        }
        stackArray[i]=false;
        return false;

    }

    public static int solve(int A, int[] B, int[] C) {
        //lets create a adjacency list
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=A;i++){
            adj.add(new ArrayList<>());
        }
        //B--->C
        for(int i=0;i<B.length;i++){
            adj.get(B[i]).add(C[i]);
        }
        int [] visited=new int[A+1];
        Arrays.fill(visited,-1);
        boolean [] stackArray=new boolean[A+1];
        Arrays.fill(stackArray,false);
        System.out.println(adj);
        for(int i=1;i<=A;i++){
            System.out.println("for "+i);
            if(visited[i]==-1){
                if(haveCycle(adj,i,visited,stackArray)){
                    return 0;
                }
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number of Courses");
        int A=sc.nextInt();
        System.out.println("enter number of course which have prerequisites");
        int M=sc.nextInt();
        int [] B=new int[M];
        int [] C=new int[M];
        for(int i=0;i<M;i++){
            B[i]=sc.nextInt();
        }
        for(int i=0;i<M;i++){
            C[i]=sc.nextInt();
        }
        int ispossible=solve(A,B,C);
        if(ispossible==1) System.out.println("Yes it is possible to finish all the courses");
        else System.out.println("No it is not possible to finish all the courses");
    }
}
