package AdvanceDSA.QueuesProblems;
/*
Given an array A of both positive and negative integers.
your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.



Problem Constraints
1 <= size of array A <= 105

-109 <= A[i] <= 109

1 <= B <= size of array
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P6_SumOFminandmax {
    public static int solve(int[] A, int B) {
        Deque<Integer> maxq=new LinkedList<>();
        Deque<Integer> minq=new LinkedList<>();
        int N=A.length;
        long totalsum=0;
        int i=0;
        int mod=1000000007;
        while (i<B){
            while (!maxq.isEmpty()&&A[i]>=A[maxq.peekLast()]){
                maxq.removeLast();
            }
            maxq.addLast(i);
            while (!minq.isEmpty()&&A[i]<=A[minq.peekLast()]){
                minq.removeLast();
            }
            minq.addLast(i);
            i++;
        }
        for(;i<N;i++){
            long max=A[maxq.peek()];
            long min=A[minq.peek()];
            long sum=(min+max+mod)%mod;
            totalsum=(totalsum+sum+mod)%mod;
            while (!maxq.isEmpty()&&maxq.peek()<=i-B){
                maxq.remove();
            }
            while (!minq.isEmpty()&&minq.peek()<=i-B){
                minq.remove();
            }
            while (!maxq.isEmpty()&&A[i]>=A[maxq.peekLast()]){
                maxq.removeLast();
            }
            maxq.addLast(i);
            while (!minq.isEmpty()&&A[i]<=A[minq.peekLast()]){
                minq.removeLast();
            }
            minq.addLast(i);

        }
        //System.out.println(totalsum);
        long max=A[maxq.peek()];
        long min=A[minq.peek()];
        long sum=(min+max+mod)%mod;
        totalsum=(totalsum+sum+mod)%mod;
        return (int) totalsum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter size of Subarray");
        int B=sc.nextInt();
        int sum=solve(A,B);
        System.out.println("Sum of all the max and min is "+sum);
    }
}
