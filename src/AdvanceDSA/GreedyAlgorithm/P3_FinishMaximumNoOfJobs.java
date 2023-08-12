package AdvanceDSA.GreedyAlgorithm;
/*
There are N jobs to be done, but you can do only one job at a time.

Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.

Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.

Return the maximum number of jobs you can finish
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P3_FinishMaximumNoOfJobs {
    static class pair{
        int S,E;
        pair(int s,int e){
            S=s;
            E=e;
        }
    }
    public static int solve(int[] A, int[] B) {
        //creating array of pair
        pair [] a=new pair[A.length];

        //Adding elements to the pair
        for(int i=0;i<A.length;i++){
            pair temp=new pair(A[i],B[i]);
            a[i]=temp;
        }
        //sort the pair according to end timing
        Arrays.sort(a, Comparator.comparingInt((pair u) -> u.E));
        //Arrays.sort(a,(pair u,pair v)->(u.E-v.E));
        int end=0,ans=0;
        for(pair job:a){
            if(job.S>=end){
                ans++;
                end=job.E;
            }
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
