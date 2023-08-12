package AdvanceDSA.TwoPointers;
/*
Problem Description
Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C and the pair has one element from each array.

More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.

If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i then return the one with minimum j.

Return an array with two elements {A[i], B[j]}.



Problem Constraints
1 <= length of both the arrays <= 105

1 <= A[i], B[i] <= 109

1 <= C <= 109



Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.
The third argument given is integer C.



Output Format
Return an array of size 2 denoting the pair which has sum closest to C.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = [2, 4, 6, 8]
 C = 9
Input 2:

 A = [5, 10, 20]
 B = [1, 2, 30]
 C = 13


Example Output
Output 1:

 [1, 8]
Output 2:

 [10, 2]


Example Explanation
Explanation 1:

 There are three pairs: (1, 8), (3, 6), (5, 4), that gives the minimum value.
 Since we have to return the value with minimum i and then with minimum j. We will return [1, 8].
Explanation 2:

 [10, 2] is the only pair such abs(10+2-13) is minimum.
 */

import java.util.Arrays;
import java.util.Scanner;

public class P10_ClosestPointFromSortedArray {
    public static int[] solve(int[] A, int[] B, int C) {
        int start_A=0;
        int end_B=B.length-1;
        int closest_val=Integer.MAX_VALUE;
        int idx_A=-1;
        int idx_B=-1;

            while (start_A<A.length && end_B>=0){
                //System.out.println(A[start_A]+" "+B[end_B]+" "+(A[start_A]+B[end_B]));
                if(A[start_A]+B[end_B]<C){
                    if(Math.abs(A[start_A]+B[end_B]-C)<=closest_val) {
                        if(closest_val == Math.abs(A[start_A] + B[end_B] - C)){
                            if(start_A==idx_A){
                                idx_B=end_B;
                            }
                        }
                        else{
                            closest_val = Math.abs(A[start_A] + B[end_B] - C);
                            idx_A = start_A;
                            idx_B = end_B;
                        }

                    }
                    start_A++; //Since sum is small we have to increase the value

                }
                else if(A[start_A]+B[end_B]==C){
                    if(Math.abs(A[start_A]+B[end_B]-C)<=closest_val) {
                        if(closest_val == Math.abs(A[start_A] + B[end_B] - C)){
                            if(start_A==idx_A){
                                idx_B=end_B;
                            }
                        }
                        else{
                            closest_val = Math.abs(A[start_A] + B[end_B] - C);
                            idx_A = start_A;
                            idx_B = end_B;
                        }
                    }
                    start_A++; //Since sum is equal so  we have to increase the value in A and decrease in B
                    end_B--;

                }
                else{
                    if(Math.abs(A[start_A]+B[end_B]-C)<=closest_val) {
                        if(closest_val == Math.abs(A[start_A] + B[end_B] - C)){
                            if(start_A==idx_A){
                                idx_B=end_B;
                            }
                        }
                        else{
                            closest_val = Math.abs(A[start_A] + B[end_B] - C);
                            idx_A = start_A;
                            idx_B = end_B;
                        }
                    }
                    end_B--; //Since sum is greater we have to decrease the value

                }
            }
        int [] res=new int[2];
        res[0]=A[idx_A];
        res[1]=B[idx_B];
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array A ");
        int N=sc.nextInt();
        int [] A=new int[N];
        System.out.println("Enter elements of the array A");
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter size of array B ");
        int M=sc.nextInt();
        int [] B=new int[M];
        System.out.println("Enter elements of the array B");
        for(int i=0;i<M;i++){
            B[i]=sc.nextInt();
        }
        System.out.println("Enter the value of C");
        int C=sc.nextInt();
        int [] elemts=solve(A,B,C);
        System.out.println(Arrays.toString(elemts));
    }
}
