package HashingProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
/*
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.

Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).

Problem Constraints
1 <= N <= 105

0 <= A[i], B[i] <= 109
 */

public class P24_CountRightTrianglr {
    public static int combrec(int A,int B,int C){
        if(A==0||B==0||A==B){
            return 1;
        }
        return (combrec(A-1,B,C)+combrec(A-1,B-1,C))%C;
    }
    public static int solve(int [] A,int [] B){
        long cnt=0;
        int mod=1000000007;
        HashMap<Integer,Integer> setx=new HashMap<>();
        HashMap<Integer,Integer> sety=new HashMap<>();
        for (int j : A) {
            setx.put(j, setx.getOrDefault(j, 0) + 1);
        }
        for (int j : B) {
            sety.put(j, sety.getOrDefault(j, 0) + 1);
        }
        System.out.println(setx);
        System.out.println(sety);
        for(int i=0;i<A.length;i++){
            System.out.println(A[i]+" "+B[i]);

            int onSameX=setx.get(A[i]);//no of point on same x axis
            int  onSameY=sety.get(B[i]);//number of point on same y axis
            //-1 coz we have to remove the count of base
            long num=((long)(onSameX-1)*(onSameY-1))%mod;//total no of combination to form triangle
            cnt=(cnt+num)%mod;
        }
        return (int)cnt;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array A followed by the elements");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter size of an array B followed by the elements");

        int [] B=new int[N];
        for(int i=0;i<N;i++) {
            B[i] = sc.nextInt();
        }
        int noofTriangle=solve(A,B);
        System.out.println("Number of Right Angle Triangle is "+noofTriangle);
    }
}
