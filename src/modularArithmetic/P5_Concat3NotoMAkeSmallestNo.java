package modularArithmetic;
/*
Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating them in any order.

Return the minimum result obtained.
 */

import java.util.Arrays;
import java.util.Scanner;

public class P5_Concat3NotoMAkeSmallestNo {
    public static int solve(int A, int B, int C) {
        int no=0;
        int max=0;
        int mid=0;
        int min=0;
        if(A>B){
            if(A>C){
                max=A;
                if(B>C){
                    mid=B;
                    min=C;
                }
                else{
                    mid=C;
                    min=B;
                }
            }
            else {
                max=C;
                mid=A;
                min=B;
            }
        }
        else {
            if(B>C){
                max=B;
                if(A>C){
                    mid=A;
                    min=C;
                }
                else{
                    mid=C;
                    min=A;
                }
            }
            else{
                max=C;
                mid=B;
                min=A;
            }
        }
        System.out.println(max+" "+mid+" "+min);
        no=min*10000+mid*100+max*1;

        return no;
    }
    public static int solve1(int A,int B,int C){
        int []arr=new int[3];
        arr[0]=A;
        arr[1]=B;
        arr[2]=C;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        return arr[0]*10000+arr[1]*100+arr[2];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
        int smallestno=solve(A,B,C);
        System.out.println("Smallest no formed from three no is "+smallestno);
        smallestno=solve1(A,B,C);
        System.out.println("Smallest no formed from three no is "+smallestno);

    }
}
