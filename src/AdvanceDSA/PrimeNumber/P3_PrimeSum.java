package AdvanceDSA.PrimeNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class P3_PrimeSum {
    public static int[] primesum(int A) {
        int [] C=new int[A+1];
        for(int i=2;i<=A;i++){
            if(C[i]==0) {
                for (int j = 2*i; j <= A; j = j + i) {
                    C[j] = 1;
                    //System.out.println(Arrays.toString(C));
                }
            }
        }
       // System.out.println(Arrays.toString(C));
        ArrayList<Integer> set=new ArrayList<>();
        for(int i=2;i<=A;i++){
            if(C[i]==0){
                set.add(i);
            }
        }
       // System.out.println(set);
        int s=0;
        int e=set.size()-1;
        int [] nos=new int[2];
        while (s<=e){
            if(set.get(s)+ set.get(e)==A){
                nos[0]=set.get(s);
                nos[1]=set.get(e);
                break;
            }
            if(set.get(s)+ set.get(e)<A){
                s++;
            }
            else {
                e--;
            }

        }
        return nos;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int []no=primesum(A);
        System.out.println(Arrays.toString(no));
    }
}
