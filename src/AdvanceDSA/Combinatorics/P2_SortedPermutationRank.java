package AdvanceDSA.Combinatorics;

import java.util.Scanner;

public class P2_SortedPermutationRank {
    public static int fact(int n){
        int fac=1;
        for(int i=1;i<=n;i++){
            fac=fac*i;
        }
        return fac;
    }

    public static int findRank(String A) {
        int n=A.length();
        int rank=0;
        while (n!=1) {
            char fstchar=A.charAt(0);
            int cnt=0;
            for(int i=1;i<n;i++){
                if(A.charAt(i)<fstchar){
                    cnt++;
                }
            }
            rank+=cnt*fact(n-1);
            String temp="";
            for (int i=1;i<n;i++){
                temp+=A.charAt(i);
            }
            A=temp;
            n--;
            //System.out.println(rank);
            //System.out.println(A);
        }

        rank++;
        return rank;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        int pos=findRank(S);
        System.out.println(pos);
    }
}
