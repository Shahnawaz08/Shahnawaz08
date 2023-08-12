package AdvanceDSA.PrimeNumber;

import java.util.Arrays;
import java.util.Scanner;

public class P2_LuckyNumber {
    public static int solve(int A) {
        int [] C=new int[A+1];
        for(int i=2;i<=A;i++){
            if(C[i]==0){
                for(int j=i;j<=A;j=j+i){
                    C[j]++;
                }
            }
        }
        int ans=0;
        for(int i=2;i<=A;i++){
            if(C[i]==2){
                ans++;
            }
        }
        return ans;
    }

}
