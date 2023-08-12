package AdvanceDSA.BitManipulation;
/*
Given an array, A of integers of size N. Find the maximum value of j - i such that A[i] <= A[j].
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class P12_maxdistance {
    public static int maximumGap(final int[] A) {
        int maxdist=0;
        int [][] arr=new int[A.length][2];
        for(int i=0;i<A.length;i++){
            arr[i][0]=A[i];
            arr[i][1]=i;
        }
        Arrays.sort(arr, Comparator.comparingInt((int [] obj)->(obj[0])));
        System.out.println(Arrays.deepToString(arr));
        int minidx=arr[0][1];
        for(int i=1;i<A.length;i++){
            int idx=arr[i][1];
            if(idx>minidx){
                int dist=idx-minidx;
                if(dist>maxdist){
                    maxdist=dist;
                }
            }
            else {
                minidx=idx;
            }

        }


        return maxdist;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr =new int[N];
        for (int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int maxdist=maximumGap(arr);
        System.out.println(maxdist);
    }
}
