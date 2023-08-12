package AdvanceDSA.BitManipulation;

import java.util.Arrays;
import java.util.Scanner;

public class P7_minXor {
    public static  int findMinXor(int[] A) {
        Arrays.sort(A);
        int xor=0;
        int minxor=Integer.MAX_VALUE;
        for(int i=0;i<A.length-1;i++){
            xor=A[i]^A[i+1];
            if(xor<minxor){
                minxor=xor;
            }
        }
        return minxor;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr =new int[N];
        for (int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int is=findMinXor(arr);
        System.out.println(is);
    }
}
