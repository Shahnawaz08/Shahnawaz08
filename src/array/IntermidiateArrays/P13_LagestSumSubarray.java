package array.IntermidiateArrays;

import java.util.Scanner;
/*
Find the contiguous non-empty subarray within an array, A of length N, with the largest sum.
 */

public class P13_LagestSumSubarray {
    public static int maxSubArray(final int[] A) {
        int sum=0;
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            sum=sum+A[i];
            if(sum<A[i]){
                sum=A[i];
            }
            if(largest<sum){
                largest=sum;
            }
        }
        return largest;
    }
    public static int maxSubArrayM2(final int[] A) {
        int sum=0;
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            sum=0;
            for(int j=0;j<A.length;j++){
                sum+=A[j];
                if(sum>largest){
                    largest=sum;
                }
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]= sc.nextInt();
        }
        int s=maxSubArray(A);
        System.out.println(s);
        s=maxSubArrayM2(A);
        System.out.println(s);

    }
}
