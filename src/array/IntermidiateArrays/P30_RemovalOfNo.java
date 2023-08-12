package array.IntermidiateArrays;
/*
Given an integer array A of size N. You can remove any element from the array in one operation.
The cost of this operation is the sum of all elements in the array present before this operation.
Find the minimum cost to remove all elements from the array.
 */

import java.util.Arrays;
import java.util.Scanner;

public class P30_RemovalOfNo {
    public static int solve(int[] A) {
        int N=A.length;
        int sum=0;
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        for(int i=0;i<N;i++){
            sum+=A[i]*(N-i);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int costOfRemoval=solve(arr);

        System.out.println("Minimum cost of removal is "+costOfRemoval);

    }
}
