package AdvanceDSA.Arrayproblems;
/*
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.
 */

import java.util.Arrays;
import java.util.Scanner;

public class P13_SpiralOrderMatrix {
    public static int[][] generateMatrix(int A) {
        int [][] arr=new int[A][A];
        int imin=0;
        int jmin=0;
        int imax=A-1;
        int jmax=A-1;
        int emt=0;
        while (true){
            for(int j=jmin;j<=jmax;j++){
                emt++;
                arr[imin][j]=emt;

            }
            if(emt==A*A){
                break;
            }
            imin++;
            for (int i=imin;i<=imax;i++){
                emt++;
                arr[i][jmax]=emt;

            }
            if(emt==A*A){
                break;
            }
            jmax--;
            for(int j=jmax;j>=jmin;j--){
                emt++;
                arr[imax][j]=emt;

            }
            if(emt==A*A){
                break;
            }
            imax--;
            for(int i=imax;i>=imin;i--){
                emt++;
                arr[i][jmin]=emt;

            }
            if(emt==A*A){
                break;
            }
            jmin++;

        }
        return arr;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int [][] matrix=generateMatrix(N);
        System.out.println(Arrays.deepToString(matrix));
    }
}
