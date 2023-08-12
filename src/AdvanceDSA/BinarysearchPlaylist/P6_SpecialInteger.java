package AdvanceDSA.BinarysearchPlaylist;
/*
Given an array of integers A and an integer B, find and
return the maximum value K such that
there is no subarray in A of size K with the sum of elements greater than B.
 */

import java.util.Arrays;
import java.util.Scanner;

public class P6_SpecialInteger {
    public static boolean canSmaller(int [] A,int B,int k){
        long sum=0;
        int s=0;
        int e=0;
        while (e<k){
            sum+=A[e];
            if(sum>B){
                return false;
            }
            e++;
        }
        //System.out.println("sum "+sum);
        while (e<A.length){
            int prevemt=A[s];
            int newemt=A[e];
            sum=sum-prevemt+newemt;
            if(sum>B){
                return false;
            }
            //System.out.println("sum "+sum);
            s++;
            e++;
        }
        return true;
    }

    public static int solve(int[] A, int B) {
        int s=1;
        int e=A.length;

        int k=1;
        while (s<=e){
            int mid=s+(e-s)/2;
            //System.out.println("mid "+mid);
            if(canSmaller(A,B,mid)){
                k=mid;
                s=mid+1;
            }
            else {
                e=mid-1;
            }

        }
        return k;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for (int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("max sum");
        int B=sc.nextInt();
        int maxsize=solve(A,B);
        System.out.println(maxsize);

    }
}
