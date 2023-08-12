package AdvanceDSA.BitManipulation;
/*
Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.

NOTE: INT_MAX = 2^31 - 1
 */

import java.util.Scanner;

public class P14_DivideInteger {
    public static int divide(int A, int B) {
        long n=A,m=B;
        int div=A;
        int sign=((A<0) ^(B<0))?-1:1;
        //System.out.println("sign "+sign);
        long absA=Math.abs(n);
        long absB=Math.abs(m);
        //System.out.println(absA+" "+absB);
        long quotient=0;
        long temp=0;
        for (int i = 31; i >= 0; --i)
        {

            if (temp + (absB << i) <= absA)
            {
                temp += absB << i;
                quotient |= (long)1 << i;
            }
            //System.out.println(quotient);
        }
        if(sign==-1) {
            quotient = -quotient;
        }
        if(quotient>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)quotient;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();

        int no=divide(A,B);
        System.out.println(no);
    }
}
