package AdvanceDSA.BinarysearchPlaylist;

import java.util.Scanner;

public class P11_AthMagicalNumber {
    public static int gcd(int A, int B) {
        while (A!=0){
            int temp=A;
            A=B%A;
            B=temp;
        }
        return B;
    }
    public static long posOfno(int B,int C,long k,long lcm){

        return k/B+k/C-k/lcm;
    }

    public static int solve(int A, int B, int C) {
        long s=Math.min(B,C);
        long e=A*s;
        long ans=-1;
        long lcm=B*C/gcd(B,C);
        while (s<=e){
            long mid=(s+e)/2;
            long num=posOfno(B,C,mid,lcm);
            if(num==A){
                ans=mid;
                e=mid-1;
            }
            else if(num<A){
                s=mid+1;
            }
            else e=mid-1;

        }
        return (int)(ans%1000000007);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
        int magicalNum=solve(A,B,C);
        System.out.println("Magical number "+magicalNum);
    }
}
