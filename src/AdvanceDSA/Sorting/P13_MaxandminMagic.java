package AdvanceDSA.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class P13_MaxandminMagic {
    public static int[] solve(int[] A) {
        Arrays.sort(A);
        int N=A.length;
        long maxsum=0;
        long minsum=0;
        for(int i=0;i<N/2;i++) {
            maxsum=(maxsum+Math.abs(A[N/2+i]-A[i]))%1000000007;
        }
        for(int i=0;i<N-1;i=i+2){
            minsum=(minsum+Math.abs(A[i+1]-A[i]))%1000000007;
        }
        int max=(int)maxsum;
        int min=(int)minsum;
        int [] arr={max,min};
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int []sum=solve(A);
        System.out.println(Arrays.toString(sum));
    }
}
