package Recursion_Problems;
/*
Implement pow(A, B) % C.
In other words, given A, B and C, Find (AB % C).

Note: The remainders on division cannot be negative. In other words, make sure the answer you return is non-negative.
 */

import java.math.BigInteger;
import java.util.Scanner;

public class P6_PowerImplementation {
    public static int pow(int A, int B, int C) {
        BigInteger  halfpow;
        if(A==0){
            return 0;
        }
        if(B==0){
            return 1;
        }
        int ansint=0;

        halfpow=BigInteger.valueOf(pow(A,B/2,C)%C);
        halfpow=halfpow.multiply(halfpow);
        BigInteger answer;
        if(B%2==0){
            answer=halfpow.mod(BigInteger.valueOf(C));
            ansint= answer.intValue();
        }
        else{
            answer=(halfpow.multiply(BigInteger.valueOf(A))).mod(BigInteger.valueOf(C));
            ansint=answer.intValue();
        }

        if(ansint<0){
            return ansint+C;
        }
        return ansint;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
        int p=pow(A,B,C);
        System.out.println(p);
    }
}
