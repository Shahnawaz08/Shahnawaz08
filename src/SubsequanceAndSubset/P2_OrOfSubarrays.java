package SubsequanceAndSubset;

import java.util.Scanner;
/*
You are given an array of integers A of size N.

The value of a subarray is defined as BITWISE OR of all elements in it.

Return the sum of value of all subarrays of A % 109 + 7.
 */

public class P2_OrOfSubarrays {
    public static  int solve(int[] A) {
        int size=A.length;
        int sum=0;
        for(int i=0;i<size;i++){
            for(int j=i;j<size;j++){
                int or=0;
                for(int k=i;k<=j;k++){
                    or=or|A[k];

                }
                //System.out.println(or);
                sum=sum+or;
                sum=sum%(int)(Math.pow(10,9)+7);
            }
        }
        return sum;
    }
    public static  int solvem2(int[] A) {
        int size=A.length;
        int sum=0;
        for(int i=0;i<size;i++){
            int or=0;
            for(int j=i;j<size;j++){
                or=or|A[j];
                sum+=or;
                sum=sum%(int)(Math.pow(10,9)+7);
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]= sc.nextInt();
        }
        int sum=solve(arr);
        System.out.println(sum);
        sum=solvem2(arr);
        System.out.println(sum);
    }
}
