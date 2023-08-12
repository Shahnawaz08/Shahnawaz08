package AdvanceDSA.Sorting;
/*
Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
Return the number of important reverse pairs in the given array A.

Problem Constraints
1 <= length of the array <= 105

-2 * 109 <= A[i] <= 2 * 109
 */

import java.util.Arrays;
import java.util.Scanner;

public class P11_ReversePairs {
    public static long merge(int[] A,int s,int mid,int e){
        int[] temp = new int[e-s+1];
        int i= s,j=mid+1,k=0;
        long ans=0;
        while(i<=mid && j<=e){
            if(A[i]>A[j]){
                if(A[i]>(2*A[j])) {
                    ans = (ans  + (long) ((mid - i + 1)  )) ;
                    System.out.println(ans);
                }
                temp[k]=A[j];
                j++;
                k++;

            }
            else if(A[j]>=A[i]){
                temp[k] = A[i];
                k++;
                i++;
            }
        }
        while(i<=mid){
            temp[k]=A[i];
            k++;
            i++;
        }
        while(j<=e){
            temp[k]=A[j];
            k++;
            j++;
        }
        i=s;
        System.out.println(Arrays.toString(temp));
        for(i=s;i<=e;i++){
            A[i]=temp[i-s];
        }
        return ans;
    }
    public static long mergeSort(int[] A,int s,int e){
        long ans=0,mod = 1000000007;
        if(s<e){
            int mid = (e+s)/2;
            ans += mergeSort(A,s,mid);

            ans += mergeSort(A,mid+1,e);

            ans += merge(A,s,mid,e);

        }
//        System.out.println(Arrays.toString(A));
        return ans;
    }
    public static int solve(int[] A) {
        int s=0,e=A.length-1;
        long ans=0;
        ans =(int)(mergeSort(A,s,e));
        return (int)(ans);
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int noofcount=solve(A);
        System.out.println(noofcount);
    }
}
