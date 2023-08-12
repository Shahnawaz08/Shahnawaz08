package AdvanceDSA.PrimeNumber;
/*
You have given an array A having N integers. Let say G is the product of all elements of A.

You have to find the number of distinct prime divisors of G.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class P5_DistinctPrimes {
    public static int solve(int[] A) {
        HashSet<Integer> set=new HashSet<>();
        int [] primesArray=getprimes(100000);
        for(int i=0;i<A.length;i++){
            //int [] primesArray=getprimes(A[i]);
            //System.out.println(Arrays.toString(primesArray));
            for (int nos:primesArray){
                if(nos>A[i]) break;
                if(A[i]%nos==0){
                    set.add(nos);
                }
            }
        }
        //System.out.println(set);
        return set.size();
    }
    public static int [] getprimes(int N){
        ArrayList<Integer> primes=new ArrayList<>();
        int [] C=new int[N+1];
        for (int i=2;i<=N;i++){
            for (int j=i+i;j<=N;j=j+i){
                C[j]=1;
            }
        }
        for (int i=2;i<=N;i++){
            if(C[i]==0){
                primes.add(i);
            }
        }
        int [] pr=new int[primes.size()];
        for (int i=0;i< primes.size();i++){
            pr[i] = primes.get(i);
        }
        return  pr;
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
