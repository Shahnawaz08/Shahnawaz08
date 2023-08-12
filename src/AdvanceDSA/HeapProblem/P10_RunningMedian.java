package AdvanceDSA.HeapProblem;
/*
Problem Description
Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.

Find and return the array C.

NOTE:

If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).
Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P10_RunningMedian {
    public static int[] solve(int[] A) {
        int N=A.length;
        int [] res=new int[N];
        //Max Heap
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(
                Collections.reverseOrder());

        //Min heap
        PriorityQueue<Integer> minheap=new PriorityQueue<Integer>();
        res[0]=A[0];
        int med=A[0];
        maxheap.add(A[0]);
        for(int i=1;i<N;i++){

            //Adding the element to the heaps
            if(A[i]>med){
                minheap.add(A[i]);
                //make the heap balance
                if(minheap.size()-maxheap.size()>=2){
                    int elmt=minheap.poll();
                    maxheap.add(elmt);
                }
            }
            else {
                maxheap.add(A[i]);
                //make the heap balance
                if(maxheap.size()-minheap.size()>=2){
                    int elmt=maxheap.poll();
                    minheap.add(elmt);
                }
            }
            //Store the median
            if(minheap.size()>maxheap.size()){
                res[i]=minheap.peek();
                med=res[i];
            }else {
                res[i]=maxheap.peek();
                med=res[i];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int [] runningMedian=solve(A);
        System.out.println(Arrays.toString(runningMedian));
    }
}
