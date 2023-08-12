package AdvanceDSA.ModularArithmetic;
/*
Given an array of integers A, find and return the count of divisors of each element of the array.

NOTE: The order of the resultant array should be the same as the input array.
 */

import java.util.Arrays;
import java.util.Scanner;

public class P4_CountTheDivisord {
    public static int getnoOfDiv(int N){
        int cnt=0;
        for(int i=1;i*i<=N;i++){
            if(N%i==0){
                int div1=i;
                int div2=N/i;
                //System.out.println(div1+" "+div2);
                if(div1==div2){
                    cnt++;
                }
                else {
                    cnt=cnt+2;
                }
            }
        }
        return cnt;
    }

    public static int[] solve(int[] A) {
        int [] parray=new int[A.length];
        for(int i=0;i<A.length;i++){
            parray[i]=getnoOfDiv(A[i]);
        }
        return parray;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++) {
            A[i] = sc.nextInt();
        }

        int []divArray=solve(A);
        System.out.println(Arrays.toString(divArray));
        //System.out.println(getnoOfDiv(5));
    }
}
