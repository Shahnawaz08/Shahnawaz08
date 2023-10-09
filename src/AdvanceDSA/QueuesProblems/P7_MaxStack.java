package AdvanceDSA.QueuesProblems;

import java.util.*;
import java.util.Scanner;
/*
Problem Description
You are given a matrix A of size N x 2 which represents different operations.
Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:

1 x: push an integer x onto the stack and return -1.

2 0: remove and return the most frequent element in the stack. This basically means the element which has the highest count among all the elements currently in the stack.

If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.

A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.



Problem Constraints
1 <= N <= 100000

1 <= A[i][0] <= 2

0 <= A[i][1] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the array of integers denoting the answer to each operation.



Example Input
Input 1:

A = [
            [1, 5]
            [1, 7]
            [1, 5]
            [1, 7]
            [1, 4]
            [1, 5]
            [2, 0]
            [2, 0]
            [2, 0]
            [2, 0]  ]
Input 2:

 A =  [
        [1, 5]
        [2, 0]
        [1, 4]   ]


Example Output
Output 1:

 [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
Output 2:

 [-1, 5, -1]
 */

public class P7_MaxStack {

        // freqMap is to map element to its frequency
        static Map<Integer, Integer> freqMap = new HashMap<>();

        // setMap is to map frequency to the
        // element list with this frequency
        static Map<Integer, Stack<Integer> > setMap = new HashMap<>();

        // Variable which stores maximum frequency
        // of the stack element
        static int maxfreq = 0;

        // Function to insert x in the stack
        public static void push(int x)
        {

            // Frequency of x
            int freq = freqMap.getOrDefault(x, 0) + 1;

            // Mapping of x with its frequency
            freqMap.put(x, freq);

            // Update maxfreq variable
            if (freq > maxfreq)
                maxfreq = freq;

            // Map element to its frequency list
            // If given frequency list doesn't exist
            // make a new list of the required frequency
            setMap.computeIfAbsent(freq, z -> new Stack()).push(x);
        }

        // Function to remove maximum frequency element
        public static int pop()
        {

            // Remove element from setMap
            // from maximum frequency list
            int top = setMap.get(maxfreq).pop();

            // Decrement the frequency of the popped element
            freqMap.put(top, freqMap.get(top) - 1);

            // If whole list is popped
            // then decrement the maxfreq
            if (setMap.get(maxfreq).size() == 0)
                maxfreq--;
            return top;
        }
        public static int[] solve(int[][] A) {
            int [] arr=new int [A.length];
            int idx=0;
            for(int i=0;i<A.length;i++){
                if(A[i][0]==1){
                    push(A[i][1]);
                    arr[idx]=-1;
                    idx++;
                }
                else{
                    int ele=pop();
                    arr[idx]=ele;
                    idx++;
                }
            }
            return arr;
        }

        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int N=sc.nextInt();
            int [][] A=new int[N][2];
            for(int i=0;i<N;i++){
                A[i][0]=sc.nextInt();
                A[i][1]=sc.nextInt();
            }
            int [] arr=solve(A);
            System.out.println(Arrays.toString(arr));
        }
    }


