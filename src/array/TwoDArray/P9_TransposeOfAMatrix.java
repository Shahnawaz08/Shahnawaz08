package array.TwoDArray;

import java.util.Arrays;
import java.util.Scanner;

public class P9_TransposeOfAMatrix {
    public static int[][] solve(int[][] A) {
        int N=A[0].length;
        int M=A.length;
        int[][] t=new int [N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                t[i][j]=A[j][i];
            }
        }
        return t;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter dimension of 2D matrix ");
        int N=sc.nextInt();
        int M=sc.nextInt();
        int [][] A=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j]=sc.nextInt();
            }
        }
        int [][] transpose=solve(A);
        for(int[]r:transpose) {
            System.out.println(Arrays.toString(r));
        }

    }
}
