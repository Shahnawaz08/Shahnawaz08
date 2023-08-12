package array.IntermidiateArrays;
/*
Given an array of size N, find the majority element. The majority
element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array.


 */

import java.util.Scanner;

public class P26_majorityElement {
    public static int majorityElement(final int[] A) {
        int N=A.length;
        int maj=A[0];
        int frq=1;
        for(int i=1;i<N;i++){
            if(frq==0){
                maj=A[i];
                frq=0;
            }
            else if(A[i]==maj){
                frq++;
            }
            else {
                frq--;
            }
        }
        return maj;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int majele=majorityElement(arr);
        System.out.println("Majority element is "+majele);

    }
}
