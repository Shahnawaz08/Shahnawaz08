package HashingProblems;
/*
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P4_SubArrayWithSumZero {
    public static int solve(int[] A) {
        int sum=0;
        HashSet<Integer> set=new HashSet<>();
        for (int elm:A) {
            sum+=elm;
            //System.out.print(sum+" ");
            if(set.contains(sum)||sum==0){
                return 1;
            }
            else{
                set.add(sum);
            }

        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size and element");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }

        int zeroSubArrayPresent=solve(A);
        System.out.println("Zero sub array present "+zeroSubArrayPresent);


    }
}
