package array.IntermidiateArrays;

import java.util.Scanner;
/*
Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A.
 */

public class P18_NoOgGoodSubArray {
    public static int solve(int[] A,int B){
        int N=A.length;
        int count=0;
        long[] ps=new long[N];
        ps[0]=A[0];
        for(int i=1;i<N;i++){
            ps[i]=ps[i-1]+A[i];
        }
        for(int i=0;i<N;i++){
            long sum=0;
            for(int j=i;j<N;j++){
                if(i==0){
                    sum=ps[j];
                }
                else{
                    sum=ps[j]-ps[i-1];
                }
                if(sum<B && (j-i+1)%2==0){
                    count++;
                }
                if(sum>B && (j-i+1)%2!=0){
                    count++;
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println("Enter size of subarray");
        int B = sc.nextInt();
        int s = solve(A, B);
        System.out.println(s);
    }
}
