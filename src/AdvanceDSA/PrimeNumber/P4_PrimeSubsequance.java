package AdvanceDSA.PrimeNumber;

import java.util.Arrays;
import java.util.Scanner;

public class P4_PrimeSubsequance {
    public static int isprime(int N){
        if(N==2){
            return 1;
        }
        for(int i=2;i*i<=N;i++){
            if(N%i==0){
                return 0;
            }
        }
        return 1;
    }

    public static int solve(int[] A) {
        int cnt=0;
        for (int i=0;i<A.length;i++){
            if(isprime(A[i])==1){
                cnt++;
            }
        }
        //System.out.println(cnt);
        int no=(1<<cnt)-1;
        System.out.println(no);
        long sol=1;
        while (cnt>0){
            sol=sol*2;
            cnt--;
        }
        sol--;
        return (int)sol;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int [] A=new int[N];
        for (int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }

        int no=solve(A);
        System.out.println(no);
    }
}
