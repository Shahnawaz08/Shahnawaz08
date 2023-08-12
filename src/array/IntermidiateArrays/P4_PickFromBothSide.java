package array.IntermidiateArrays;

/*
Problem Description
You are given an integer array A of size N.
You have to pick B elements in total. Some (possibly 0)
elements from left end of array A and some (possibly 0) from the right end
 of array A to get the maximum sum.
 Input 1:
 A = [5, -2, 3 , 1, 2]
 B = 3
 Output 1:
   8


 */

import java.util.Arrays;
import java.util.Scanner;

public class P4_PickFromBothSide {
    public static int solve(int[] A, int B) {
        long[] ps=new long[A.length+1];
        ps[0]=0;
        ps[1]=A[0];
        for(int i=1;i<A.length;i++){
            ps[i+1]=ps[i]+A[i];
        }
        System.out.println(Arrays.toString(ps));
        long[] ss=new long[A.length+1];
        ss[0]=0;
        ss[1]=A[A.length-1];
        for(int i=1;i<A.length;i++){
            ss[i+1]=ss[i]+A[A.length-1-i];
        }
        System.out.println(Arrays.toString(ss));
        long maxsum=Integer.MIN_VALUE;
        for(int i=0;i<=B;i++){
            long sum=ps[i]+ss[B-i];
            if(sum>maxsum){
                maxsum =sum;
            }

        }
        return (int)maxsum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of an array followed by elements ");
        int N=sc.nextInt();
        int[] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("enter number of element ");
        int B= sc.nextInt();
        int maxSum=solve(A,B);
        System.out.println("Maximum sum of "+B+" Element from either side is "+maxSum);
    }
}
