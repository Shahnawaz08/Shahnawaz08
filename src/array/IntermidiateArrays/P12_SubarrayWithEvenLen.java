package array.IntermidiateArrays;
/*
You are given an integer array A.
Decide whether it is possible to divide the array into one or more subarrays
of even length such that the first and last element of all subarrays will be even.
Return "YES" if it is possible; otherwise, return "NO" (without quotes).
 */

import java.util.Arrays;
import java.util.Scanner;

public class P12_SubarrayWithEvenLen {
    public static String solve(int[] A) {
        int n=A.length;
        if(n%2==1){
            return "NO";
        }
        if(A[0]%2 !=0 || A[n-1]%2 !=0){
            return "NO";
        }

        for(int i=1;i<n-1;i++){
            if(A[i]%2==0&&A[i+1]%2==0){
                if((i+1)%2==0 &&((n-i-1)%2==0)){
                    return "YES";
                }
            }

        }
        return "last NO";

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]= sc.nextInt();
        }
        String s=solve(A);
        System.out.println(s);

    }
}
