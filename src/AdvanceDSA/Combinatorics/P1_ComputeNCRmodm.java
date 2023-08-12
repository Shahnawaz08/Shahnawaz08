package AdvanceDSA.Combinatorics;
/*
Given three integers A, B, and C, where A represents n, B represents r, and C represents m,
find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
Problem Constraints
1 <= A * B <= 106

1 <= B <= A

1 <= C <= 106
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P1_ComputeNCRmodm {
    public static int comb(int A,int B,int C){
        ArrayList<Integer> init=new ArrayList<>(A);
        init.add(0);
        for (int i=0;i<=A;i++){
            //int [] arr=new int[i+1];
            ArrayList<Integer> arr=new ArrayList<>();
            arr.add(0,0);
            arr.add(i,0);
            for (int j=1;j<i;j++){
               // arr[j]=(init[j-1]+init[j])%C;
                arr.add(j,(init.get(j-1)+init.get(j))%C);
            }
            init=arr;
        }
        System.out.println(init);
        return init.get(B);
    }
    public static int combitt(int A,int B,int C){
        int [][] arr=new int[A+1][A+1];
        for (int i=0;i<=A;i++){
            arr[i][0]=arr[i][i]=1;
            for (int j=1;j<i;j++){
                arr[i][j]=(arr[i-1][j-1]+arr[i-1][j])%C;
            }
        }
        System.out.println(Arrays.deepToString(arr));
        return arr[A][B];
    }

    public static int combrec(int A,int B,int C){
        if(A==0||B==0||A==B){
            return 1;
        }
        return (combrec(A-1,B,C)+combrec(A-1,B-1,C))%C;
    }

    public static int solve(int A, int B, int C) {
        return comb(A,B,C);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int C=sc.nextInt();
        int val=solve(A,B,C);
        System.out.println(val);
        //System.out.println(comb(3,0));
    }
}
