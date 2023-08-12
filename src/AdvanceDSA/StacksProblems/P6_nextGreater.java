package AdvanceDSA.StacksProblems;
/*
Problem Description
Given an array A, find the next greater element G[i] for every element A[i] in the array.
The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.

More formally:

G[i] for an element A[i] = an element A[j] such that
    j is minimum possible AND
    j > i AND
    A[j] > A[i]
Elements for which no greater element exists, consider the next greater element as -1.



Problem Constraints
1 <= |A| <= 105

1 <= A[i] <= 107
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class P6_nextGreater {
    public static int[] nextGreater(int[] A) {
        Stack<Integer> S=new Stack<>();
        int N=A.length;
        int [] res=new int[N];
        for(int i=N-1;i>=0;i--){
            while (!S.isEmpty()&&S.peek()<=A[i]){
                S.pop();
            }
            if(S.isEmpty()){
                res[i]=-1;

            }
            else {
                res[i]=S.peek();
            }
            S.add(A[i]);
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
        int [] res=nextGreater(A);
        System.out.println(Arrays.toString(res));
    }
}
