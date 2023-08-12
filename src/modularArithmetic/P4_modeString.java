package modularArithmetic;

import java.util.Scanner;

public class P4_modeString {
    public static int findMod(String A, int B) {
        long ans=0;
        int N=A.length();
        long pow=1;
        for(int i=N-1;i>=0;i--){
            long dig=A.charAt(i)-'0';
            ans+=((dig%B)*pow)%B;
            pow=(pow*10)%B;
            ans=ans%B;
        }
        int sol=(int)ans;
        return sol;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int B=sc.nextInt();
        String A=sc.next();
        int mod=findMod(A,B);
        System.out.println(A);
        System.out.println("mode of a number is "+mod);
    }
}
