package Recursion_Problems;

import java.util.Scanner;

public class P4_powerFn {
    public static int pow(int a,int n) {
        if(n==0){
            return 1;
        }
        int halfpow=pow(a,n/2);
        if(n%2==0){
            return halfpow*halfpow;
        }
        return a*halfpow*halfpow;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int N=sc.nextInt();
        int power=pow(a,N);
        System.out.println("Sum of digit of given number is "+power);
    }
}
