package AdvanceDSA.HeapProblem;

import java.util.PriorityQueue;
import java.util.Scanner;
/*
You are given an array A of integers that represent the lengths of ropes.
You need to connect these ropes into one rope. The cost of joining two ropes
equals the sum of their lengths.
Find and return the minimum cost to connect these ropes into one rope.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 1000
 */
public class P1_ConnectRopes {
    public static int solve(int[] A) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int sum=0;
        for(int i:A){
            pq.add(i);
        }
        //System.out.println(pq);
        while (pq.size()>=2){
            //Add two smallest rops so that smaller will come more time
            int fst= pq.poll();
            int sec= pq.poll();
            int total=fst+sec;
            sum=sum+total;
            pq.add(total);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int minCost=solve(A);
        System.out.println("Minimum cost of connect "+minCost);
    }
}
