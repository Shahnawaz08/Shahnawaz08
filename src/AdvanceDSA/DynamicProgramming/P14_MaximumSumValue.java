package AdvanceDSA.DynamicProgramming;
/*
You are given an array A of N integers and three integers B, C, and D.

You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.



Problem Constraints

1 <= N <= 105

-10000 <= A[i], B, C, D <= 10000
 */

import java.util.Arrays;
import java.util.Scanner;

public class P14_MaximumSumValue {
    public static int solve(int[] A, int B, int C, int D) {
        //size of the array
        int N=A.length;
        //create a maxprefix ,min prefix ,max suffix and min suffix array;
        int []maxPrefix=new int [N];
        int []minPrefix=new int [N];
        int []maxSuffix=new int [N];
        int []minSuffix=new int [N];
        //storing prefix
        for(int i=0;i<N;i++){
            if(i==0){
                maxPrefix[i]=A[i];
                minPrefix[i]=A[i];
                continue;
            }
            maxPrefix[i]=Math.max(A[i],maxPrefix[i-1]);
            minPrefix[i]=Math.min(A[i],minPrefix[i-1]);
        }
        for(int i=N-1;i>=0;i--){
            if(i==N-1){
                maxSuffix[i]=A[i];
                minSuffix[i]=A[i];
                continue;
            }
            maxSuffix[i]=Math.max(A[i],maxSuffix[i+1]);
            minSuffix[i]=Math.min(A[i],minSuffix[i+1]);
        }
//        System.out.println(Arrays.toString(maxPrefix));
//        System.out.println(Arrays.toString(minPrefix));
//        System.out.println(Arrays.toString(maxSuffix));
//        System.out.println(Arrays.toString(minSuffix));
        int maxsum=0;
        for(int i=0;i<N;i++){
            int fstterm=Integer.MIN_VALUE;
            int secterm=Integer.MIN_VALUE;
            int thirdterm=Integer.MIN_VALUE;
            secterm=A[i]*C;
            if(B>0) fstterm= maxPrefix[i]*B;
            else fstterm=minPrefix[i]*B;
            if(D>0)thirdterm=maxSuffix[i]*D;
            else thirdterm=minSuffix[i]*D;
            int sum=fstterm+secterm+thirdterm;
            maxsum=Math.max(maxsum,sum);
        }
        return maxsum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //Number of element in array
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int B=sc.nextInt();
        int C=sc.nextInt();
        int D= sc.nextInt();
        int maxsum=solve(A,B,C,D);
        System.out.println("Maximum of A[i]*B + A[j]*C + A[k]*D is "+maxsum);
    }
}
