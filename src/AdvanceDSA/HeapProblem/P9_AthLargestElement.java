package AdvanceDSA.HeapProblem;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P9_AthLargestElement {
    public static int[] solve(int A, int[] B) {
        int N=B.length;
        int [] ans=new int[N];
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<=A-1;i++){
            pq.add(B[i]);
            if(i<A-1) {
                ans[i] = -1;
            }
            else {
                ans[i]=pq.peek();
            }
        }

        for(int i=A;i<N;i++){
            pq.add(B[i]);
            int smallest=pq.poll();
            int Athsmallest=pq.peek();
            ans[i]=Athsmallest;

        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int N=sc.nextInt();
        int [] B=new int[N];
        for(int i=0;i<N;i++){
            B[i]=sc.nextInt();
        }
        int []ans=solve(A,B);
        System.out.println(Arrays.toString(ans));
    }
}
