package AdvanceDSA.Arrayproblems;

import java.util.Scanner;

public class P15_MinimumSwaps2 {
    public static int solve(int[] A) {
        int swap=0;

        for(int i=0;i<A.length;i++){
            while (A[i]!=i){
                int temp=A[A[i]];
                A[A[i]]=A[i];
                A[i]=temp;
                swap++;
            }

        }
        return swap;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }

        int minswap=solve(arr);
        System.out.println(minswap);
    }
}
