package AdvanceDSA.BinarysearchPlaylist;
/*
Given an integer A.

Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).
DO NOT USE SQRT FUNCTION FROM THE STANDARD LIBRARY.

NOTE: Do not use the sqrt function from the standard library. Users are expected to solve this in O(log(A)) time.

Problem Constraints
0 <= A <= 1010
 */

import java.util.Scanner;

public class P4_sqRootOfNo {
    public static int sqrt(int A) {
        long s=0;
        long e=A;
        long ans=0;
        while (s<=e){
            long mid=s+(e-s)/2;

            if(mid*mid<=A){
                System.out.println("s"+s+" e"+e);
                s=mid+1;
                ans=mid;
            }
            if(mid*mid>A){
                System.out.println("s"+s+" e"+e);
                e=mid-1;
            }
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int A=sc.nextInt();
        int sqroot=sqrt(A);
        System.out.println(sqroot);

    }

}
