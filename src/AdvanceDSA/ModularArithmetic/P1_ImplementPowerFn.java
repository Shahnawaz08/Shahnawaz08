package AdvanceDSA.ModularArithmetic;

import java.util.Scanner;

public class P1_ImplementPowerFn {
    public static int mod(int x,int C){
        return (((x%C)+C)%C);
    }
    public static int mul(int A,int B,int C){
        return mod(mod(A,C)*mod(B,C),C);
    }

    public static int modpow(int A,int B,int C){
        if(B==0) return 1;
        if(B==1) return mod(A,C);
        int res=1;
        while (B>0){
            if(B%2==1) res=mul(res,A,C);
            A=mul(A,A,C);
            B=B/2;
        }
        return res;
    }

    public static int pow(int A, int B, int C) {
        if(A==0){
            return 0;
        }
        return modpow(A,B,C);
    }
    public static int pow2(int A, int B, int C) {
        int power=1;
        for(int i=0;i<B;i++){
            power=(power*(A%C))%C;
        }
        return power;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
        int minswap=pow2(A,B,C);
        System.out.println(minswap);
        minswap=pow(A,B,C);
        System.out.println(minswap);
    }
}
