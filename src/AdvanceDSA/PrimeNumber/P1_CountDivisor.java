package AdvanceDSA.PrimeNumber;

import java.util.Arrays;
import java.util.Scanner;

public class P1_CountDivisor {
    public static int countPrime(int N){
        int count=0;
        for(int i=1;i*i<=N;i++){
            if(N%i==0){
                int div1=i;
                int div2=N/i;
                if(div1==div2){
                    count=count+1;
                }
                else {
                    count=count+2;
                }
            }
        }
        return count;
    }

    public static int[] solve(int[] A) {
        int len=A.length;
        int [] primearray=new int[len];
        for(int i=0;i<len;i++){
            primearray[i]=countPrime(A[i]);
        }
        return  primearray;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int [] A=new int[N];
        for (int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }

        int []arr=solve(A);
        System.out.println(Arrays.toString(arr));
    }
}
