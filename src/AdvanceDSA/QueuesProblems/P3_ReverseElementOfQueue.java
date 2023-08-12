package AdvanceDSA.QueuesProblems;

import java.util.*;
/*
Given an array of integers A and an integer B, we need to reverse the order of the first B elements of the array, leaving the other elements in the same relative order.

NOTE: You are required to the first insert elements into an auxiliary queue then perform Reversal of first B elements.

Problem Constraints
1 <= B <= length of the array <= 500000
1 <= A[i] <= 100000
 */

public class P3_ReverseElementOfQueue {
    public static int[] solve(int[] A, int B) {
        Queue<Integer> Q=new LinkedList<>();
        for (int j : A) {
            Q.add(j);
        }
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<B;i++){
            s.add(Q.remove());
        }
        while (!s.empty()){
            Q.add(s.pop());
        }
        //System.out.println(Q);
        int rem=A.length-B;
        while (rem-->0){
            int no=Q.remove();
            Q.add(no);
        }
        //System.out.println(Q);
        int [] res=new int[A.length];
        int idx=0;
        while (!Q.isEmpty()){
            res[idx]=Q.remove();
            idx++;
        }
        return res;
    }

        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<A.length;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("How many element to reverse");
        int B=sc.nextInt();
        int [] revarray=solve(A,B);
        System.out.println(Arrays.toString(revarray));
    }
}
