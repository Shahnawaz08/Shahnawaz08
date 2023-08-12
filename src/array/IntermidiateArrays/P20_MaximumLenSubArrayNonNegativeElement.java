package array.IntermidiateArrays;
/*
Given an array of integers A, of size N.
Return the maximum size subarray of A having only non-negative elements.
If there are more than one such subarray, return the one having the smallest starting index in A.
 NOTE: It is guaranteed that an answer always exists.

Problem Constraints
1 <= N <= 105

-109 <= A[i] <= 109
 */

import java.util.Scanner;

public class P20_MaximumLenSubArrayNonNegativeElement {
    public static int[] solve(int[] A) {
        int N=A.length;
        int start=0;
        while(A[start]<0){
            start++;
        }
        int end;
        int startindex=-1;
        int endindex=-1;

        int largestLen=Integer.MIN_VALUE;
        for(int i=start+1;i<N;i++){

            if(A[i]<0){
                end=i-1;
                int currlen=end-start+1;
                if(currlen>largestLen){
                    largestLen=currlen;
                    System.out.println(start+" "+end);
                    startindex=start;
                    endindex=end;
                }
                while (i<N-1&&A[i]<0){
                    i++;
                }
                start=i;
            }
            else if (i==N-1) {
                end=N-1;
                int currlen=end-start+1;
                if(currlen>largestLen){
                    largestLen=currlen;
                    System.out.println(start+" "+end);
                    startindex=start;
                    endindex=end;
                    start=i+1;
                }
            }



        }
        System.out.println("starting index "+startindex+"ending index "+endindex);
        int L=endindex-startindex+1;
        int [] arr=new int[L];
        for(int i=0;i<L;i++){
            arr[i]=A[startindex+i];
        }
        return arr;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N= sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int[] subarray=solve(arr);
        for(int a:subarray){
            System.out.print(a+" ");
        }
    }
}
