package AdvanceDSA.StacksProblems;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
/*
Given an array A, find the nearest smaller element G[i] for every element A[i]
in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that

j is maximum possible AND

j < i AND

A[j] < A[i]

Elements for which no smaller element exist, consider the next smaller element as -1.



Problem Constraints
1 <= |A| <= 100000

-109 <= A[i] <= 109
 */

public class P4_NearestSmallerElement {
    public static int[] prevSmaller(int[] A) {
        Stack<Integer> S=new Stack<>();
        int N=A.length;
        int [] res=new int[N];
        for(int i=0;i<N;i++){
            while (!S.isEmpty()&&S.peek()>=A[i]){
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
        int [] res=prevSmaller(A);
        System.out.println(Arrays.toString(res));
    }
}
