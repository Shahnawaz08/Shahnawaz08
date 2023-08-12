package AdvanceDSA.Sorting;
/*
Find the Bth smallest element in given array A .
NOTE: Users should try to solve it in less than equal to B swaps.
Problem Constraints
1 <= |A| <= 100000

1 <= B <= min(|A|, 500)

1 <= A[i] <= 109
 */

import java.util.Arrays;
import java.util.Scanner;

public class P4_KthSmallest {
    public static int kthsmallesteff(final int[] A, int B) {
        for (int i = 0; i < B; i++) {
            int minn = Integer.MAX_VALUE, idx = 0;
            for (int j = i; j < A.length; j++) {
                if (A[j] < minn) {
                    minn = A[j];
                    idx = j;
                }
            }
            int tmp = A[i];
            A[i] = A[idx];
            A[idx] = tmp;
    }
        return A[B - 1];
   }

    public static int kthsmallest(final int[] A, int B) {
    int [] arr=new int[A.length];
    for(int i=0;i<A.length;i++){
        arr[i]=A[i];
    }
    Arrays.sort(arr);
    return arr[B-1];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int B=sc.nextInt();
        int no=kthsmallest(A,B);
        System.out.println(no);
        no=kthsmallesteff(A,B);
        System.out.println(no);

    }
}
