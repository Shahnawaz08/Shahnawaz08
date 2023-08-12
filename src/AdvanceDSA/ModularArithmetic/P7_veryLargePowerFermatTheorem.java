package AdvanceDSA.ModularArithmetic;

import java.util.Scanner;

public class P7_veryLargePowerFermatTheorem {
    public static int fast_power(long A,long B,long mod){
        long ans=1;
        while (B>0){
            if((B&1)==1){
                ans=(ans*A)%mod;
            }
            A=(A%mod*A%mod)%mod;
            B=B>>1;
        }
        return (int) (ans%mod);
    }

    public static int solve(int A, int B) {
        long fact=1;
        long mod=(long)(1e9+7);
        //calculating factorial of B
        for(long i=2;i<=B;i++){
            fact=(fact*i)%(mod-1);//(mod-1) is used according tp fermat little theorem
        }
        int ans=fast_power(A,fact,mod);
        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();

        int B = sc.nextInt();

        int no = solve(A, B);
        System.out.println(no);


    }
}
