package AdvanceDSA.GcdProblems;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P3_DeleteOne {
    public static int getGcd(int A, int B) {
        while (A!=0){
            int temp=A;
            A=B%A;
            B=temp;
        }
        return B;
    }
    public static int solve(int[] A) {
        int N=A.length;
        int [] pslgcd=new int[N];
        pslgcd[0]=A[0];
        for(int i=1;i<A.length;i++){
            pslgcd[i]=getGcd(pslgcd[i-1], A[i]);
        }
        int [] psRgcd=new int[N];
        /*
        psRgcd[0]=A[N-1];
        for(int i=1;i<A.length;i++){
            psRgcd[i]=getGcd(psRgcd[i-1], A[N-i-1]);
        }

         */
        psRgcd[N-1]=A[N-1];
        for(int i=1;i<A.length;i++){
            psRgcd[N-i-1]=getGcd(psRgcd[N-i], A[N-i-1]);
        }
        System.out.println(Arrays.toString(pslgcd));
        System.out.println(Arrays.toString(psRgcd));
        int maxgcd=psRgcd[1];
        for(int i=1;i<N;i++){
            int L=pslgcd[i-1];
            int R=0;
            if(i==N-1){
                R=0;
            }else {
                R=psRgcd[i+1];
            }
            int gcd=getGcd(L,R);
            maxgcd=Math.max(gcd,maxgcd);

        }

        return maxgcd;
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
