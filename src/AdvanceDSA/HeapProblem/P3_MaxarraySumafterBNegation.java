package AdvanceDSA.HeapProblem;

import java.util.PriorityQueue;
import java.util.Scanner;
/*
Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].

You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.

Problem Constraints
1 <= length of the array <= 5*105
1 <= B <= 5 * 106
-100 <= A[i] <= 100
 */

public class P3_MaxarraySumafterBNegation {
    public static int solve(int[] A, int B) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:A){
            pq.add(i);
        }
        while (B>0){
            int min=pq.poll();
            min=-min;
            pq.add(min);
            B--;
        }
        int maxsum=0;
        while (!pq.isEmpty()){
            maxsum=maxsum+pq.poll();
        }
        return maxsum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter value of B");
        int B=sc.nextInt();
        int maxArraySum=solve(A,B);
        System.out.println("Maxumun sum after negating "+B+" times is "+maxArraySum);
    }
}
