package AdvanceDSA.BitManipulation;
/*
Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.

NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

import java.util.Arrays;
import java.util.Scanner;

public class P2_SingleNumber {
    public static int singleNumber(final int[] A) {
        int xored=0;
        int x=0;
        int y=0;
        for(int item: A){
            xored=xored^item;
        }

        return xored;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }

        int no=singleNumber(arr);
        System.out.println((no));
    }
}
