package AdvanceDSA.TwoPointers;
/*
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).


Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9
 */

import java.util.Scanner;

public class P6_PairWithGivenSum2 {
    public static int solve(int[] A, int B) {
        int mod=1000000007;
        int s=0;
        int e=A.length-1;
        int sum=0;
        long noOfElement=0;
        while (s<e){
            long fst=A[s];
            long sec=A[e];
            if(fst+sec==B){
                if(A[s]==A[e]){
                    long n=e-s+1;
                    noOfElement=(noOfElement+((n*(n-1))/2)%mod)%mod;
                    break;
                }
                //12 1 1 2 2 3 3 4 5 5 6 9 10
                int cntleft=1;
                int cntRight=1;
                while (A[s]==A[s+1]&&s<e){
                    s++;
                    cntleft++;
                }
                while (A[e]==A[e-1]&&s<e){
                    e--;
                    cntRight++;
                }
                noOfElement=(noOfElement+(cntleft*cntRight)%mod)%mod;
                s++;
            }
            else if(fst+sec<B){
                s++;
            }
            else {
                e--;
            }
        }
        return (int)noOfElement;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Size of the array followed by the elements");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Sum ");
        int B=sc.nextInt();
        int noOfPair=solve(A,B);
        System.out.printf("Number of pair having sum %d is %d",B,noOfPair);
    }
}
