package AdvanceDSA.HeapProblem;

import java.util.PriorityQueue;
import java.util.Scanner;
/*
Misha loves eating candies. She has been given N boxes of Candies.

She decides that every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. Can you find how many candies she will eat?

NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).

NOTE 2: The same box will not be chosen again.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 105

1 <= B <= 106
 */

public class P7_MishaAndCandies {
    public static int solve(int[] A, int B) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long totalchoc=0;
        for(int i:A){
            pq.add(i);
        }
        while (!pq.isEmpty()){
            int noChoc=pq.poll();
            if(noChoc<=B) {
                totalchoc = totalchoc + noChoc / 2;
                if(!pq.isEmpty()) {
                    int rem = noChoc - noChoc / 2;
                    int nextsmall = pq.poll() + rem;
                    pq.add(nextsmall);
                }
            }
        }
        return (int)totalchoc;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int B=sc.nextInt();
        int maxChocolate=solve(A,B);
        System.out.println("Max chocolate that a Misha will eat is "+maxChocolate);
    }
}
