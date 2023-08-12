package array.TwoDArray;
/*
You are given a 2D integer matrix A,
make all the elements in a row or column zero if the A[i][j] = 0.
 Specifically, make entire ith row and jth column zero
 */

import java.util.Arrays;
import java.util.Scanner;

public class P14_makewholeColandRowZero {
    public static int[][] solve(int[][] A) {
        int N=A.length;
        int M=A[0].length;
        int[] rowarray=new int[N];
        int[] colarray=new int[M];
        int [][] c=new int [N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(A[i][j]==0){
                    rowarray[i]=1;
                    colarray[j]=1;

                }
            }
        }
        for(int i=0;i<N;i++){
            if(rowarray[i]!=1) {
                for (int j = 0; j < M; j++) {
                    if (colarray[j]!=1) {
                        c[i][j]=A[i][j];

                    }
                }
            }
        }
        return c;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of matrix ");
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] d = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                d[i][j] = sc.nextInt();
            }
        }
        int[][] dret = new int[N][M];
        dret = solve(d);
        for (int[] a : dret) {
            System.out.println(Arrays.toString(a));
        }

    }
}
