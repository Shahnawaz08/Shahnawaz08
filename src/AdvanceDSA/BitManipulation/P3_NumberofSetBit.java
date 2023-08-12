package AdvanceDSA.BitManipulation;
/*
Write a function that takes an integer and returns the number of 1 bits it has.
 */

import java.util.Scanner;

public class P3_NumberofSetBit {
    public static int numSetBits(int A) {
        int noOfSetBit=0;
        while (A!=0){
            int bit=A%2;
            A=A/2;
            if(bit==1){
                noOfSetBit++;
            }

        }
        return noOfSetBit;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();


        int no=numSetBits(A);
        System.out.println((no));
    }
}
