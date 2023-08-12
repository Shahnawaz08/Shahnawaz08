package AdvanceDSA.GcdProblems;

import java.util.Scanner;

public class P6_LCM {
    public static int gcd(int A, int B) {
        while (A!=0){
            int temp=A;
            A=B%A;
            B=temp;
        }
        return B;
    }
    public static int lcm(int A,int B){
        int lcm=(A*B)/gcd(A,B);
        return lcm;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();

        int B=sc.nextInt();

        int no=lcm(A,B);
        System.out.println(no);
    }
}
