package bits_manupulation;
/*
Given an integer A. Unset B bits from the right of A in binary.
For eg:-
A = 93, B = 4
A in binary = 1011101
A should become = 1010000 = 80. Therefore return 80
 */

import java.util.Scanner;

public class P3_Unsetxbits {
    public static long solve(long A, int B) {
        long bit= (long)Math.pow(2,B)-1;
        bit=~bit;
        System.out.println(bit);

        long transA=A&bit;
       return transA;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        long N=sc.nextLong();
        System.out.println("Enter the N0 of bit");
        int B=sc.nextInt();
        long NAfter=solve(N,B);
        System.out.println("Number after b bit unset "+NAfter);
    }
}
