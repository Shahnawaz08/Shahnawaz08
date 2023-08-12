package AdvanceDSA.TwoPointers;
/*
Given a sorted array of distinct integers A and an integer B,
find and return how many rectangles with distinct configurations can be
created using elements of this array as length and breadth whose area is lesser than B.

(Note that a rectangle of 2 x 3 is different from 3 x 2 if
we take configuration into view)

Problem Constraints

1 <= |A| <= 100000
1 <= A[i] <= 109
1 <= B <= 109
 */

import java.util.Scanner;

public class P2_AnotherCountRectangle {
    public static int solve(int[] A, int B) {
        int mod=1000000007;
        int s=0;
        int e=A.length-1;
        long cnt=0;
        while (s<e){
            long area=(long) A[s]*A[e];
            if(area<B){
                cnt=(cnt+(e-s))%mod;
                s++;
            }
            if(area>=B){
                e--;
            }

        }
        cnt=(cnt+cnt)%mod;
        for(int i=0;i<A.length;i++){
            long area= (long) A[i] *A[i];
            if(area<B){
                cnt=(cnt+1)%mod;
            }
            if(area==B){
                break;
            }
        }
        return (int) cnt;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array followed bt elements ");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter area of rectangle");
        int B=sc.nextInt();
        int cntOfRect=solve(A,B);
        System.out.println("Number of Rectangle whose area is smaller than "+B+" "+cntOfRect);

    }
}
