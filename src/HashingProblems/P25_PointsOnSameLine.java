package HashingProblems;
/*
Given two arrays of integers A and B describing a pair of (A[i], B[i])
coordinates in a 2D plane. A[i] describe x coordinates of the ith point in the 2D plane,
whereas B[i] describes the y-coordinate of the ith point in the 2D plane.
Find and return the maximum number of points that lie on the same line.

Problem Constraints
1 <= (length of the array A = length of array B) <= 1000

-105 <= A[i], B[i] <= 105
 */

import java.util.HashMap;
import java.util.Scanner;

public class P25_PointsOnSameLine {
    public static int solve(int[] A, int[] B) {
        int N=A.length;
        HashMap<Integer,Integer> setx=new HashMap<>();
        HashMap<Integer,Integer> sety=new HashMap<>();
        HashMap<Integer,Integer> line=new HashMap<>();
        for(int i=0;i<N;i++){
            setx.put(A[i],setx.getOrDefault(A[i],0)+1);
            sety.put(B[i],sety.getOrDefault(B[i],0)+1);

        }
        System.out.println(setx);
        System.out.println(sety);
        return 0;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int [] B=new int[N];
        for(int i=0;i<N;i++){
            B[i]=sc.nextInt();
        }
        int maxpointInstrightLine=solve(A,B);
        System.out.println("Maximum number of point in a straight line is "+maxpointInstrightLine);
    }
}
