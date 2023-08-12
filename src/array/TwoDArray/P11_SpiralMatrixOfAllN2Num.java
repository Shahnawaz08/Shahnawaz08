package array.TwoDArray;

import java.util.Arrays;
import java.util.Scanner;

public class P11_SpiralMatrixOfAllN2Num {
    public static int[][] generateMatrix(int A) {

        int num=1;
        int minrow=0;
        int maxrow=A;
        int mincol=0;
        int maxcol=A;
        int[][] sp=new int[A][A];
        while (num<=A*A) {
            for (int i = mincol; i < maxcol && num <A*A; i++) {
                sp[minrow][i] = num;
                num++;
            }
            minrow++;
            for (int i = minrow; i < maxrow && num <A*A; i++) {
                sp[i][maxcol-1] = num;
                num++;
            }
            maxcol--;


            for (int i = maxcol - 1; i >= mincol && num <=A*A; i--) {
                sp[maxrow-1][i] = num;
                num++;
            }
            maxrow--;
            for (int i = maxrow - 1; i >= minrow && num <=A*A; i--) {
                sp[i][mincol] = num;
                num++;
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
