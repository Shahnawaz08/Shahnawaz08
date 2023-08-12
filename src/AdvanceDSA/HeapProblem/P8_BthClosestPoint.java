package AdvanceDSA.HeapProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P8_BthClosestPoint {
    static class Pair implements Comparable<Pair>
    {
        int first, second;
        Pair(int a, int b)
        {
            first = a;
            second = b;
        }

        public int compareTo(Pair o)
        {
            int x1 = first * first;
            int y1 = second * second;
            int x2 = o.first * o.first;
            int y2 = o.second * o.second;
            return (x1 + y1) - (x2 + y2);
        }
    }
    public static int[][] solve(int[][] A, int B) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();

        // Pushing all the points
        // in the queue
        for(int i = 0; i < A.length; i++)
        {
            pq.add(new Pair(A[i][0],A[i][1]));
        }

        // Print the first K elements
        // of the queue
        ArrayList<Integer> a1=new ArrayList<>();
        for(int i = 0; i < B; i++)
        {

            // Remove the top of the queue
            // and store in a temporary pair
            Pair p = pq.poll();
            a1.add(p.first);
            a1.add(p.second);
            ArrayList<Integer> a2=new ArrayList<>(a1);
            arr.add(a2);
            a1.clear();

            // Print the first (x)
            // and second (y) of pair
//            System.out.println(p.first +
//                    " " + p.second);
        }
        //System.out.println(arr);
        int [][] res=new int[arr.size()][];
        for(int j=0;j<arr.size();j++){
            int [] temp=new int[2];
            temp=arr.get(j).stream().mapToInt(i->i).toArray();
            res[j]=temp;
        }
        return res;
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
        int [][] sol=solve(A,B);
        System.out.println(Arrays.deepToString(sol));

    }
}
