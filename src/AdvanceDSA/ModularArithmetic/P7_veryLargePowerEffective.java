package AdvanceDSA.ModularArithmetic;

import java.util.Scanner;

public class P7_veryLargePowerEffective {
    public static int pow(int A, int B, int C) {
        if(A==0){
            return 0;
        }
        if(B==0){
            return 1;
        }
        long tempPow=(long)pow(A,B/2,C);
        long power=(tempPow*tempPow)%C;
        power=(power+C)%C;
        if(B%2==0){
            return (int)power;
        }
        power= (A*power)%C;
        return (int)(power+C)%C;

    }
    public static long fact(int A,int B,int cnt,int mod){
        if(cnt==B){
            return pow(A,B,mod);
        }
        return fact(pow(A,cnt,mod),B,cnt+1,mod);
    }

    public static int solve(int A, int B) {
        int mod=1000000007;
        long ans=fact(A,B,1,mod);
        return (int)(ans%mod);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();

        int B=sc.nextInt();

        int no=solve(A,B);
        System.out.println(no);

    }
}
