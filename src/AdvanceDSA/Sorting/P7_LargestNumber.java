package AdvanceDSA.Sorting;
/*
Given an array A of non-negative integers, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.

Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109
 */

import java.util.Arrays;
import java.util.Scanner;

public class P7_LargestNumber {
    public static boolean comp(int A,int B){
        String A1=Integer.toString(A);
        String B1=Integer.toString(B);
        int n=A1.length();
        int m=B1.length();
        int min=Math.min(n,m);
        int i=0;
        for( i=0;i<min;i++){
            if(A1.charAt(i)>B1.charAt(i)){
                return true;
            }
            if(A1.charAt(i)<B1.charAt(i)){
                return false;
            }
        }

        return false;
    }

    static void merge(int a[], int beg, int mid, int end)
    {
        int i, j, k;
        int n1 = mid - beg + 1;
        int n2 = end - mid;

        int []LeftArray=new int[n1];
        int []RightArray=new int[n2];//temporary arrays

        /* copy data to temp arrays */
        for (int x = 0; x < n1; x++)
            LeftArray[x] = a[beg + x];
        for (int y = 0; y < n2; y++)
            RightArray[y] = a[mid + 1 + y];

        i = 0; /* initial index of first sub-array */
        j = 0; /* initial index of second sub-array */
        k = beg;  /* initial index of merged sub-array */

        while (i < n1 && j < n2)
        {
            //if(LeftArray[i] <= RightArray[j])
            if(comp(LeftArray[i],RightArray[j]))
            {
                a[k] = LeftArray[i];
                i++;
            }
            else
            {
                a[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i<n1)
        {
            a[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j<n2)
        {
            a[k] = RightArray[j];
            j++;
            k++;
        }
    }

    static void  mergeSort(int a[], int beg, int end)
    {
        if (beg < end)
        {
            int mid = (beg + end) / 2;
            mergeSort(a, beg, mid);
            mergeSort(a, mid + 1, end);
            merge(a, beg, mid, end);
        }
    }
    public static String largestNumber(final int[] A) {
        int [] B=new int[A.length];
        System.arraycopy(A, 0, B, 0, A.length);
        mergeSort(B,0,B.length-1);
        System.out.println(Arrays.toString(B));
        String S="";
        for(int i=0;i<B.length;i++){
            S+=Integer.toString(B[i]);
        }
        return S;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        String S=largestNumber(A);
        System.out.println(S);
    }
}
