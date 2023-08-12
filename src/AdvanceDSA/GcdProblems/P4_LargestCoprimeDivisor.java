package AdvanceDSA.GcdProblems;

import java.util.Scanner;

public class P4_LargestCoprimeDivisor {
    /*
    You are given two positive numbers A and B . You need to find the maximum valued integer X such that:

X divides A i.e. A % X = 0
X and B are co-prime i.e. gcd(X, B) = 1

     */
    public static int gcd(int A, int B) {
        while (A!=0){
            int temp=A;
            A=B%A;
            B=temp;
        }
        return B;
    }
    public static int cpFact(int A, int B) {
        int x=A;
        if(B>A){
            return A;
        }
        while ((gcd(x,B))!=1){
            x=x/gcd(x,B);
        }
        return x;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();

        int B=sc.nextInt();

        int no=cpFact(A,B);
        System.out.println(no);
    }
}
