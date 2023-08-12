package AdvanceDSA.PrimeNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class P5_DistinctPrimesusingPrimefactorSheve {
    public static int [] getprimes(int N){
        ArrayList<Integer> primes=new ArrayList<>();
        int [] C=new int[N+1];
        for (int i=2;i<=N;i++) {
            if (C[i] == 0) {
                for (int j = i; j <= N; j = j + i) {
                    if(C[j]==0) {
                        C[j] = i;
                    }
                }
            }
        }
        //System.out.println("prime steve"+Arrays.toString(C));

        return  C;
    }
    public static int solve(int[] A) {
        HashSet<Integer>set=new HashSet<>();
        int [] primesArray=getprimes(100000);
        for(int i=0;i<A.length;i++){
            int N=A[i];
            while (N>1){
                set.add(primesArray[N]);
                N=N/primesArray[N];

            }

        }
        //System.out.println(set);
        return set.size();
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
