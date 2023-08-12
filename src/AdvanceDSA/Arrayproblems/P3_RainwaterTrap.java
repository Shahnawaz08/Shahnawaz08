package AdvanceDSA.Arrayproblems;

import java.util.Scanner;
/*
Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.
 */

public class P3_RainwaterTrap {
    public static int trap(final int [] A){
        int watertrapped=0;
        int N=A.length;
        for(int i=0;i<A.length;i++){
            int left=Integer.MIN_VALUE;
            for(int j=0;j<=i;j++){
                if(A[j]>left){
                    left=A[j];
                }

            }
            int right=Integer.MIN_VALUE;
            for(int j=i;j<N;j++){
                if(A[j]>right){
                    right=A[j];
                }
            }
            watertrapped+=Math.min(left,right)-A[i];
        }
        return watertrapped;
    }

    public static int trapeff(final int[] A) {
        int watertrapped=0;
        int N=A.length;
        int [] left=new int[N];
        left[0]=A[0];
        for(int i=1;i<N;i++){
            left[i]=Math.max(A[i],left[i-1]);
        }
        int [] right=new int[N];
        right[N-1]=A[N-1];
        for(int i=N-2;i>=0;i--){
            right[i]=Math.max(A[i],right[i+1]);
        }
        for(int i=0;i<N;i++){
            watertrapped+=Math.min(left[i], right[i])-A[i];
        }

        return watertrapped;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int waterTrapped = trap(arr);
        System.out.println(waterTrapped);
        waterTrapped = trapeff(arr);
        System.out.println(waterTrapped);

    }
}
