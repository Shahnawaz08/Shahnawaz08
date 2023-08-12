package HashingProblems;
/*
Given a number A, find if it is COLORFUL number or not.
If number A is a COLORFUL number return 1 else, return 0.

What is a COLORFUL Number:
A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.
 */

import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class P10_ColourfullNumber {
    public static int colorful(int A) {
        long productofSubArray=1;
        HashSet<Long> product=new HashSet<>();
        ArrayList<Integer> digits=new ArrayList<>();
        while (A>0){
            digits.add(A%10);
            A=A/10;
        }
        int N=digits.size();
        //System.out.println(N);
        //System.out.println(digits);
        //System.out.println("Size of int is"+N);
        for(int i=0;i<N;i++){
            long mul=1;
            for(int j=i;j<N;j++){
                mul=mul*digits.get(j);
                if(product.contains(mul)){
                    return 0;
                }
                product.add(mul);
            }
        }
        System.out.println(product);

        return 1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int n=colorful(A);
        if(n==1){
            System.out.println("Number is colorfull");
        }
        else {
            System.out.println("Number is not colorful");
        }

    }
}
