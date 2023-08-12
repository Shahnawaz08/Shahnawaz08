package AdvanceDSA.BitManipulation;

import java.util.Scanner;

public class P0_DecimalToBinary {
    public static int toBinary(int A) {
        int ans=0;
        int p=1;
        while (A!=0){
            int lstdgt=A%2;
            ans=ans+lstdgt*p;
            p=p*10;
            A=A>>1;

        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();


        int no=toBinary(A);
        System.out.println((no));
    }
}
