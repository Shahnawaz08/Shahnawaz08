package AdvanceDSA.BinarysearchPlaylist;
/*
Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.

Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.

Problem Constraints
1 <= A <= 1000
1 <= B <= 106
1 <= N <= 105
1 <= C[i] <= 106
 */

import java.util.Scanner;

public class P7_PaintersPartitionProblem {
    public static boolean canExecte(int[] C,int A,int B,long timelimit){
        long w=0;
        long cnt=1;
        for(int i=0;i<C.length;i++){
            if(w+(C[i]*1L*B)<=timelimit){
                w=w+C[i]*1L*B;
            }
            else {
                cnt++;
                w=C[i]*1L*B;
                if(cnt>A ){
                    return false;
                }
            }
        }
        // if(cnt>A ){
        //             return false;
        //         }
        return true;
    }

    public static int paint(int A, int B, int[] C) {
        long s=0;
        long e=0;
        long ans=0;
        for(int i=0;i<C.length;i++){
            if((C[i]*1L*B)>s){
                s=C[i]*1L*B;
            }
            e=e+C[i]*1L*B;
        }
        while (s<=e){
            long mid=(s+e)/2;
            if(canExecte(C,A,B,mid)){
                ans=mid;
                e=mid-1;
            }
            else {
                s=mid+1;
            }
        }
        return (int)(ans%10000003);

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int N=sc.nextInt();
        int [] C=new int[N];
        for(int i=0;i<N;i++){
            C[i]=sc.nextInt();
        }
        int maxtime=paint(A,B,C);
        System.out.println(maxtime);
    }
}
