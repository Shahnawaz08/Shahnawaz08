package AdvanceDSA.BitManipulation;
/*
We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.
 */

import java.util.Arrays;
import java.util.Scanner;

public class P8_DifferentBitsSumPairs {
    public static int cntBits(int[] A) {
        int N=A.length;
        int count=0;
        int [] bitarray=new int[32];
        for(int i=0;i<N;i++){
            int p=0;
            int emt=A[i];
            while (emt!=0){
                bitarray[p]+=emt&1;
                emt=emt>>1;
                p++;
            }
        }
        System.out.println(Arrays.toString(bitarray));
        for(int i=0;i<32;i++){
            if(bitarray[i]!=0 &&bitarray[i]!=N) {
                count = (count + Math.max(N - bitarray[i], bitarray[i])*Math.min(N - bitarray[i], bitarray[i]));//count+bitarray[i]*N-bitarr[i];
            }
        }
        count=count*2;
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr =new int[N];
        for (int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int is=cntBits(arr);
        System.out.println(is);
    }
}
