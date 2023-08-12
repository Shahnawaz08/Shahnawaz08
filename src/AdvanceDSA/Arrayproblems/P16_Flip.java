package AdvanceDSA.Arrayproblems;
/*
You are given a binary string A(i.e., with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices, L and R, such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean changing character 0 to 1 and vice-versa.

Your aim is to perform ATMOST one operation such that in the final string number of 1s is maximized.

If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.



Problem Constraints
1 <= size of string <= 100000
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P16_Flip {
    public static int [] kadans(int [] A){
        int s=-1;
        int e=-1;
        int start=0;
        int N=A.length;
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<N;i++){
            int no=A[i];
            sum=sum+no;
            System.out.println("Sum "+sum);
            if(sum>maxSum){
                maxSum=sum;
                s=start;
                e=i;
                System.out.println(s+" "+e);
            }
            if(sum<0){
                sum=0;
                start=i+1;
            }
        }
       // System.out.println(maxSum);
        return new int[]{s,e};
    }
    public static int[] flip(String A) {
        /*
        here i am converting this problem to maximum sum subarray
        because we need the subarray coz we need to find the subarray
        which we have to swap to get the max number of 1
        sp here we are making 1 to -1 and 0 to 1

         */
        int [] arr=new int[A.length()];
        for(int i=0;i<A.length();i++){
            int no=A.charAt(i)-'0';
            if(no==1){
                no=-1;
            }else {
                no=1;
            }
            arr[i]=no;
        }
        int [] idx=kadans(arr);
        if(idx[0]==-1){
            return new int[0];
        }
        idx[0]++;
        idx[1]++;
        return idx;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        int [] idx=flip(S);
        System.out.println(Arrays.toString(idx));

    }
}
