package AdvanceDSA.StacksProblems;
/*
Given an array of integers A.

value of a array = max(array) - min(array).

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class P8_MaxandMin {
    public static int[] prevSmaller(int[] A) {
        Stack<Integer> S=new Stack<>();
        int N=A.length;
        int [] res=new int[N];
        for(int i=0;i<N;i++){
            while (!S.isEmpty()&&A[S.peek()]>=A[i]){
                S.pop();
            }
            if(S.isEmpty()){
                res[i]=-1;

            }
            else {
                res[i]=S.peek();
            }
            S.add(i);
        }
        return res;
    }
    public static int[] nextSmaller(int[] A) {
        Stack<Integer> S=new Stack<>();
        int N=A.length;
        int [] res=new int[N];
        for(int i=N-1;i>=0;i--){
            while (!S.isEmpty()&&A[S.peek()]>=A[i]){
                S.pop();
            }
            if(S.isEmpty()){
                res[i]=N;

            }
            else {
                res[i]=S.peek();
            }
            S.add(i);
        }
        return res;
    }
    public static int[] nextGreater(int[] A) {
        Stack<Integer> S=new Stack<>();
        int N=A.length;
        int [] res=new int[N];
        for(int i=N-1;i>=0;i--){
            while (!S.isEmpty()&&A[S.peek()]<=A[i]){
                S.pop();
            }
            if(S.isEmpty()){
                res[i]=N;

            }
            else {
                res[i]=S.peek();
            }
            S.add(i);
        }
        return res;
    }
    public static int[] prevGreater(int[] A) {
        Stack<Integer> S=new Stack<>();
        int N=A.length;
        int [] res=new int[N];
        for(int i=0;i<N;i++){
            while (!S.isEmpty()&&A[S.peek()]<=A[i]){
                S.pop();
            }
            if(S.isEmpty()){
                res[i]=-1;

            }
            else {
                res[i]=S.peek();
            }
            S.add(i);
        }
        return res;
    }
    public static int solve(int[] A) {
        long sum=0;
        int [] leftSmall=prevSmaller(A);
        int [] rightSmall=nextSmaller(A);
        int [] leftGreat=prevGreater(A);
        int [] rightGreat=nextGreater(A);

        for(int i=0;i<A.length;i++){
            long smallStartIdx=i-leftSmall[i];
            long smallEndIdx=rightSmall[i]-i;
            long totalSmallsub=(smallStartIdx*smallEndIdx)%1000000007;
            long contributewhensmaller=(totalSmallsub*A[i])%1000000007;
            long largestStartIndex=i-leftGreat[i];
            long largestEndIndex=rightGreat[i]-i;
            long totalLargsub=(largestStartIndex*largestEndIndex)%1000000007;
            long contibutewhenLargest=(totalLargsub*A[i])%1000000007;
            long tempsum=(contibutewhenLargest-contributewhensmaller+1000000007)%1000000007;
            sum=(sum+tempsum)%1000000007;
        }
        return (int)sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int sum=solve(A);
        System.out.println("Sum of all the values "+sum);
    }
}
