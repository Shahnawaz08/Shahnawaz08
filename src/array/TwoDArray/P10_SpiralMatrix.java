package array.TwoDArray;
/*
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
 */

import java.util.Arrays;
import java.util.Scanner;

public class P10_SpiralMatrix {
    public static int[][] generateMatrix(int A) {
        Scanner scn=new Scanner(System.in);
        int num=A*A;
        int minrow=0;
        int maxrow=A;
        int mincol=0;
        int maxcol=A;
        int[][] sp=new int[A][A];
        while (num>0) {
            for (int i = mincol; i < maxcol && num > 0; i++) {
                sp[minrow][i] = scn.nextInt();
                num--;
            }
            minrow++;
            for (int i = minrow; i < maxrow && num > 0; i++) {
                sp[i][maxcol-1] = scn.nextInt();
                num--;
            }
            maxcol--;


            for (int i = maxcol - 1; i >= mincol && num > 0; i--) {
                sp[maxrow-1][i] = scn.nextInt();
                num--;
            }
            maxrow--;
            for (int i = maxrow - 1; i >= minrow && num > 0; i--) {
                sp[i][mincol] = scn.nextInt();
                num--;
            }
            mincol++;
        }
        return sp;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of matrix ");
        int A=sc.nextInt();
        int[][] sqmatrix=new int[A][A];
        sqmatrix=generateMatrix(A);
        for(int[] a:sqmatrix){
            System.out.println(Arrays.toString(a));
        }

    }
}
