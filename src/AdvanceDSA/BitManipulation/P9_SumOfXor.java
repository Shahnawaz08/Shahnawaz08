package AdvanceDSA.BitManipulation;

import java.util.Scanner;

public class P9_SumOfXor {
    public static int xorsum(int [] A){
        int sum=0;
        int [] bitarray=new int[32];
        int N=A.length;
        for (int i=0;i<N;i++){
            int emt=A[i];
            int p=0;
            while (emt!=0){
                int set=emt&1;
                bitarray[p]+=set;
                p++;
                emt=emt>>1;

            }
        }
        int pow=1;
        for(int i=0;i<32;i++){
            sum+=bitarray[i]*(N-bitarray[i])*pow;
            pow=pow*2;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr =new int[N];
        for (int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int is=xorsum(arr);
        System.out.println(is);
    }
}
