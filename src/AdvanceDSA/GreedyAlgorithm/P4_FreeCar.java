package AdvanceDSA.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P4_FreeCar {
    static class pair{
        int day,profit;
        pair(int s,int e){
            day=s;
            profit=e;
        }
    }
    public static int solve(int[] A, int[] B) {
        //creating array of pair
        pair[] a=new pair[A.length];

        //Adding elements to the pair
        for(int i=0;i<A.length;i++){
            pair temp=new pair(A[i],B[i]);
            a[i]=temp;
        }
        //sort the pair according to end timing
        Arrays.sort(a, Comparator.comparingInt((pair u) -> u.day));
        //Arrays.sort(a,(pair u,pair v)->(u.E-v.E));
        int end=0,ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int i=0;i<a.length;i++){
            if(a[i].day>pq.size()){
                pq.add(a[i].profit);
            } else if (pq.peek()<a[i].profit) {
                pq.poll();
                pq.add(a[i].profit);
            }
        }
        while (!pq.isEmpty()){
            ans+=pq.poll();
        }


        return ans;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Size of the array");
        int N=sc.nextInt();
        System.out.println("Element of the array");
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int [] B=new int[N];
        System.out.println("Element of next array");
        for(int i=0;i<N;i++){
            B[i]=sc.nextInt();
        }
        int maxJob=solve(A,B);
        System.out.println("Maximum number of job tab can be done is "+maxJob);

    }
}
