package modularArithmetic;

import java.util.Scanner;

public class P6_HCF {
    public static int solve(int A,int B){
        int hcf=1;
        while (A!=0 &&B!=0){
            if(A>B){
                A=A%B;
                if(A==0){
                    hcf=B;
                }
            }
            else {
                B=B%A;
                if(B==0){
                    hcf=A;
                }
            }

        }
        return hcf;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int hcf=solve(A,B);
        System.out.println("Hcf of two number is "+hcf);
        int lcm=(A*B)/hcf;
        System.out.println("Lcm of two number is "+lcm);
    }
}
