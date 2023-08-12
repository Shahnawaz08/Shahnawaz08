package AdvanceDSA.Sorting;
/*
Given an array A of N integers where the i-th element represent the number of chocolates in the i-th packet.

There are B number of students, the task is to distribute chocolate packets following below conditions:

1. Each student gets one packet.
2. The difference between the number of chocolates given to any two students is minimum.
Return the minimum difference (that can be achieved) between the student who gets minimum number of chocolates and the student who gets maximum number of chocolates.

Problem Constraints
0 <= N <= 10^5
1 <= A[i] <= 10^7
0 <= B <= 10^5
 */

import java.util.Arrays;
import java.util.Scanner;

public class P5_ChocolateDistribution {
    public static int solve(int[] A, int B) {
        if(A.length==0||B==0){
            return 0;
        }
        Arrays.sort(A);
        int minimum =Integer.MAX_VALUE;
        int s=0;
        int e=B-1;
        minimum=Math.min(minimum,A[e]-A[s]);
        s++;
        e++;
        while (e<A.length){
            minimum=Math.min(minimum,A[e]-A[s]);
            s++;
            e++;
        }

        return minimum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int B=sc.nextInt();
        int no=solve(A,B);
        System.out.println(no);


    }
}
