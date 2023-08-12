package AdvanceDSA.BinarysearchPlaylist;
/*
There are two sorted arrays A and B of sizes N and M respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

NOTE:

The overall run time complexity should be O(log(m+n)).
IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.


Problem Constraints
1 <= N + M <= 2*106
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P13_medianOfArray {
    public static double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
        int n = A.size();
        int m = B.size();
        if (n > m)
            return findMedianSortedArrays(B,
                    A); // Swapping to make A smaller

        int start = 0;
        int end = n;
        int realmidinmergedarray = (n + m + 1) / 2;

        while (start <= end) {
            int mid = (start + end) / 2;
            int leftAsize = mid;
            int leftBsize = realmidinmergedarray - mid;
            int leftA
                    = (leftAsize > 0)
                    ? A.get(leftAsize - 1)
                    : Integer
                    .MIN_VALUE; // checking overflow
            // of indices
            int leftB = (leftBsize > 0) ? B.get(leftBsize - 1)
                    : Integer.MIN_VALUE;
            int rightA = (leftAsize < n)
                    ? A.get(leftAsize)
                    : Integer.MAX_VALUE;
            int rightB = (leftBsize < m)
                    ? B.get(leftBsize)
                    : Integer.MAX_VALUE;

            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB)
                            + Math.min(rightA, rightB))
                            / 2.0;
                return Math.max(leftA, leftB);
            }
            else if (leftA > rightB) {
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return 0.0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        List<Integer> a=new ArrayList<>();
        for(int i=0;i<N;i++){
            int temp=sc.nextInt();
            a.add(temp);
        }
        int M=sc.nextInt();
        List<Integer> b=new ArrayList<>();
        for(int i=0;i<M;i++){
            int temp=sc.nextInt();
            b.add(temp);
        }

        double median=findMedianSortedArrays(a,b);

        System.out.println("Magical number "+median);
    }
}
