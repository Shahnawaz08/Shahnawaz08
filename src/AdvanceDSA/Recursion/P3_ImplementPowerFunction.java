package AdvanceDSA.Recursion;

import java.util.Scanner;

public class P3_ImplementPowerFunction {

    //yet to program
    public static int powItr2(int a,int b,int c){
        int ans=0;
        if(a==0){
            return 0;
        }
        if(b==0){
            return 1;
        }
        int x=a;
        while (b>0){

            //if(b is even

            //if b is odd
            if(b%2!=0) {
                if(ans==0) ans=1;
                ans=ans*a;
                b=b-1;
            }
            else  {
                ans = ans +x;

                b=b/2;
            }
            x=x*x;
            System.out.println(ans);
        }
        return ans;
    }
    public static int powItr(int a,int b,int c){
        int ans=0;
        if(a==0){
            return 0;
        }
        if(b==0){
            return 1;
        }
        int x=a;
        while (b>0){
            int dig=(b&1);
            if(dig==1){
                ans=(ans+x)%c;
            }
            x=(x*x)%c;
            b=b>>1;
            //System.out.println(ans);
        }
        return ans;
    }

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
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
        int sum=pow(A,B,C);
        System.out.println(sum);
        sum=powItr(A,B,C);
        System.out.println(sum);
    }
}
