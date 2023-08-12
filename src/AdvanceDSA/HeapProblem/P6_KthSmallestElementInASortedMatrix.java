package AdvanceDSA.HeapProblem;

import java.util.PrimitiveIterator;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
Given a sorted matrix of integers A of size N x M and an integer B.
Each of the rows and columns of matrix A is sorted in ascending order,
find the Bth smallest element in the matrix.
NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.

Problem Constraints
1 <= N, M <= 500

1 <= A[i] <= 109

1 <= B <= N * M
 */

public class P6_KthSmallestElementInASortedMatrix {
    public static int solve(int[][] A, int B) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int N=A.length;
        int M=A[0].length;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                pq.add(A[i][j]);
            }
        }
        int no=0;
        while (!pq.isEmpty()&&B>0){
           no= pq.poll();
           B--;
        }
        return no;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int B=sc.nextInt();
        int N=sc.nextInt();
        int M=sc.nextInt();
        int [][] A=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j]=sc.nextInt();
            }
        }
        int kthSmallest=solve(A,B);
        System.out.println("Kth smallest element is "+kthSmallest);

    }
}
