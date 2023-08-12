package AdvanceDSA.BitManipulation;

import java.util.Scanner;
//convert binary to decimal

public class P0_BinaryToDecimal {
    public static int toDecimal(int A) {
        int ans=0;
        int p=1;
        while (A!=0){
            int lstdigit=A%10;
            ans+=lstdigit*p;
            A=A/10;
            p*=2;

        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();


        int no=toDecimal(A);
        System.out.println((no));
    }
}
