package AdvanceDSA.Arrayproblems;
/*
Given a non-negative number represented as an array of digits, add 1 to the number
( increment the number represented by the digits ).
The digits are stored such that the most significant digit is at the head of the list.
NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example: for this problem, the following are some good questions to ask :
Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
A: For the purpose of this question, YES
Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P5_AddOneToANumber {
    public static int[] plusOne(int[] A) {
       // ArrayList<Integer> arr=new ArrayList<>();
        int N=A.length;
        int carry=1;
        for(int i=N-1;i>=0;i--){
            A[i]+=carry;
            carry=A[i]/10;
            A[i]=A[i]%10;
        }
        if(carry>0){
            int [] arr=new int[N+1];
            arr[0]=carry;
            for (int i=0;i<N;i++){
                arr[i+1]=A[i];
            }
            return arr;
        }
        int j=0;
        while (j<N &&A[j]==0){
            j++;
        }
        int [] arr=new int[N-j];
        int index=0;
        System.out.println(Arrays.toString(A));
        for(;j<N;j++){
            arr[index]=A[j];
            index++;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int [] increased=plusOne(arr);
        System.out.println(Arrays.toString(increased));
    }
}
