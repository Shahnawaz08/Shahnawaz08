package AdvanceDSA.Sorting;
/*
Problem Description
You are given an array A of N elements. You have to make all elements unique.
To do so, in one step you can increase any number by one.
Find the minimum number of steps.
Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
 */

import java.util.Arrays;
import java.util.Scanner;

public class P9_UniqueElements {
    public static int merge(int[] A,int s,int mid,int e){
        int[] temp = new int[e-s+1];
        int i= s,j=mid+1,k=0;
        int ans=0;
        while(i<=mid && j<=e){
            if(A[i]>A[j]){
                temp[k]=A[j];
                j++;
                k++;
            }
            else if(A[j]>A[i]){
                temp[k] = A[i];
                k++;
                i++;
            }
            else {
                A[j]=A[j]+1;
                ans++;
                int x=j;
                while (x<e &&A[x]>=A[x+1]){//here we are increasing all the element right of
                    ans=A[x]+1-A[x+1];//element to maintain the sort
                    A[x+1]=A[x]+1;
                    x++;
                }

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
        for(i=s;i<=e;i++){
            A[i]=temp[i-s];
        }
        return ans;
    }
    public static int mergeSort(int[] A,int s,int e){
        int ans=0;
        if(s<e){
            int mid = (e+s)/2;
            ans += mergeSort(A,s,mid);
            ans += mergeSort(A,mid+1,e);
            ans += merge(A,s,mid,e);

        }
        return ans;
    }
    //it is giving tle for hard case
    public static int solve2(int[] A) {
        int s=0,e=A.length-1;
        int ans=0;
        ans =mergeSort(A,s,e);
        return ans;

    }
    public static int solve(int[] A) {
        int ans=0;
        Arrays.sort(A);
        for(int i=1;i<A.length;i++){
            if(A[i]<=A[i-1]){
                ans+=A[i-1]+1-A[i];
                A[i]=A[i-1]+1;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int minNo=solve(A);
        System.out.println(minNo);
        minNo=solve2(A);
        System.out.println(minNo);
    }
}
