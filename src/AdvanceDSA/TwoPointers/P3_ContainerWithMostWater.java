package AdvanceDSA.TwoPointers;
/*
Given n non-negative integers A[0], A[1], ..., A[n-1] ,
where each represents a point at coordinate (i, A[i]).
N vertical lines are drawn such that the two endpoints of line i
is at (i, A[i]) and (i, 0).

Find two lines, which together with x-axis forms a container,
such that the container contains the most water.

Note: You may not slant the container.



Problem Constraints
0 <= N <= 105

1 <= A[i] <= 105
 */

import java.util.Scanner;

public class P3_ContainerWithMostWater {
    public static  int maxArea(int[] A) {
        int s=0;
        int e=A.length-1;
        int ans=0;
        while (s<e){
            int tempAns=(e-s)*Math.min(A[s],A[e]);
            ans=Math.max(ans,tempAns);
            if(A[s]<A[e]) s++;
            else e--;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int maxArea=maxArea(A);
        System.out.println("MAx area of the containber is "+maxArea);

    }
}
