package array.IntermidiateArrays;
/*
Given an array A of N non-negative numbers and a non-negative number B,
you need to find the number of subarrays in A with a sum less than B.
 */

import java.util.Scanner;

public class P17_NoOfSubarraySumSmallThan {
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
                if(sum<B){
                    count++;
                }
                else {

                    break;
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
