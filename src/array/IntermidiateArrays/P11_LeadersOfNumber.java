package array.IntermidiateArrays;
/*
Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
An element is a leader if it is strictly greater than all the elements to its right side.

NOTE:The rightmost element is always a leader.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P11_LeadersOfNumber {
    public static int[] solve(int[] A) {
        int N=A.length;
        int []leader=new int[N];
        int count=0;
        int max=A[N-1];
        leader[count]=A[N-1];
        count++;
        for(int i=N-2;i>=0;i--){
            if(A[i]>max){
                max=A[i];
                leader[count]=A[i];
                count++;
            }
        }
        int[] fLead=new int[count];
        for(int i=0;i<count;i++){
            fLead[i]=leader[i];
        }
        return  fLead;




    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]= sc.nextInt();
        }
        int[] led=solve(A);
        System.out.println(Arrays.toString(led));

    }
}
