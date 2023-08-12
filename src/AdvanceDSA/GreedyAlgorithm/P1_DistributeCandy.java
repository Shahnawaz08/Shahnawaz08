package AdvanceDSA.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class P1_DistributeCandy {
    public static int candy(int[] A) {
        int [] res=new int[A.length];
        int totalcandy=0;
        res[0]=1;
        for(int i=1;i<A.length;i++){
            if(A[i]>A[i-1]){
                res[i]=res[i-1]+1;
            }
            else {
                res[i]=1;
            }
        }
        System.out.println(Arrays.toString(res));
        for(int i=A.length-2;i>=0;i--){
            if(A[i]>A[i+1]){
                res[i]=Math.max(res[i],res[i+1]+1);
            }
        }
        System.out.println(Arrays.toString(res));
        for (int j : res) {
            totalcandy += j;
        }

        return totalcandy;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int totalCandy=candy(A);
        System.out.println("Total number of candy is "+totalCandy);
    }
}
