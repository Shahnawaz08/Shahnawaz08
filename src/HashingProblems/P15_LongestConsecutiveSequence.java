package HashingProblems;
/*
Problem Description
Given an unsorted integer array A of size N.
Find the length of the longest set of consecutive elements from array A.

Problem Constraints
1 <= N <= 106
-106 <= A[i] <= 106
 */
//run for 1 2 2 2 3 4 5 5 5

import java.util.Arrays;
import java.util.Scanner;

public class P15_LongestConsecutiveSequence {
    public static int longestConsecutive(final int[] A) {
        int maxClen=0;
        Arrays.sort(A);
        int ans=1;
        for (int i=1;i<A.length;i++){
            if(A[i]==A[i-1]+1){
                    ans++;
                    maxClen=Math.max(maxClen,ans);
            }
            else if(A[i]==A[i-1]){
                continue;
            }
            else {
                ans=1;
            }
        }
        return maxClen;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int no=longestConsecutive(arr);
        System.out.println("Longest conecutive number "+no);
    }
}
