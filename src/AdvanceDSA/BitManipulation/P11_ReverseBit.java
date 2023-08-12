package AdvanceDSA.BitManipulation;

import java.util.Scanner;

public class P11_ReverseBit {
    public static long reverse(long a) {
        long no=a;
        long rev=0;
        long index=31;
        while (no!=0){
            long bit=no&1;
            long pow=1<<index;
            System.out.println(pow);
            if(pow<0){
                pow=pow*-1;
            }
            System.out.println(pow);
            rev+=bit*(pow);
            System.out.println(rev);
            //System.out.println(1<<index);
            index--;
            no=no>>1;
            System.out.println("sum"+rev);
        }
        return rev;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long N=sc.nextInt();

        long rev=reverse(N);
        System.out.println(rev);
    }
}
