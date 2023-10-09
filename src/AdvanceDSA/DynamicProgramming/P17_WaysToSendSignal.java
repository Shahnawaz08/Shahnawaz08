package AdvanceDSA.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class P17_WaysToSendSignal {
    public static int solve(int A) {
        int mod=1000000007;
        if(A==1) return 2;
        if(A==0) return 1;
        return (solve(A-1)%mod+solve(A-2)%mod)%mod;


    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //length of the input array
        int A=sc.nextInt();

        int noOFflip=solve(A);
        System.out.println("Number of element to be flip to get the minimum non negative number is "+noOFflip);
    }
}
