package AdvanceDSA.BitManipulation;
/*
Given an array of integers, every element appears thrice except for one, which occurs once.

Find that element that does not appear thrice.

NOTE: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?
 */

import java.util.Arrays;
import java.util.Scanner;

public class P4_findsingleInTriplet {
    public static int singleNumber(final int[] A) {
        int [] bit=new int[32];
        for(int i=0;i<A.length;i++){
            int emt=A[i];
            int p=0;
            while (emt!=0){
                if((emt&1)==1){
                    bit[p]+=1;
                }
                emt=emt>>1;
                p++;
            }
        }
        System.out.println(Arrays.toString(bit));
        int num=0;
        for(int i=0;i<32;i++){
            num+=(bit[i]%3)*(1<<i);
        }
        return num;
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
