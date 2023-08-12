package AdvanceDSA.Arrayproblems;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P8_BeggarsOutsideTemple {
    public static int[] solve(int A, int[][] B) {
        int [] total=new int[A];
        for(int i=0;i<B.length;i++){
            int start=B[i][0]-1;//-1 since array is 0 indexed
            int end=B[i][1]-1;
            int amount=B[i][2];
            for(int j=start;j<=end;j++){
                total[j]+=amount;
            }
        }
        return total;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [][] arr=new int[N][3];
        for(int i=0;i<N;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("no of elements");
        int B=sc.nextInt();
        int [] total=solve(B,arr);
        System.out.println(Arrays.toString(total));
    }
}
