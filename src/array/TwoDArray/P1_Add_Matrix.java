package array.TwoDArray;

import java.util.Scanner;

public class P1_Add_Matrix {
    public static int[][] solve(int[][] A, int[][] B) {
        int N=A.length;
        int M=A[0].length;
        int [][]C=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                C[i][j]= A[i][j]+B[i][j];
            }
        }
        return C;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N =sc.nextInt();
        int M=sc.nextInt();
        int [][]A=new int[N][M];
        int [][]B=new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j]= sc.nextInt();
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                B[i][j]= sc.nextInt();
            }
        }



        int [][]C=new int[N][M];
        C=solve(A,B);
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                System.out.print(C[i][j] +" ");
            }
            System.out.println();
        }
    }
}
