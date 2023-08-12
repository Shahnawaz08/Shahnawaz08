package array.TwoDArray;

import java.util.Scanner;

public class P8_MatrixMultiplication {
    public static int[][] solve(int[][] A, int[][] B) {
        int N = A.length;
        int M = B[0].length;
        int[][] C = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int sum = 0;
                for (int k = 0; k < A[0].length; k++) {
                    sum += A[i][k] * B[k][j];
                }
                C[i][j] = sum;
            }
        }
        return C;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N1 = sc.nextInt();
        int M1 = sc.nextInt();
        int[][] A = new int[N1][M1];


        for (int i = 0; i < N1; i++) {
            for (int j = 0; j < M1; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        int N2 = sc.nextInt();
        int M2 = sc.nextInt();
        int[][] B = new int[N2][M2];
        for (int i = 0; i < N2; i++) {
            for (int j = 0; j < M2; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        int[][] C = new int[N1][M2];
        C = solve(A, B);
        for (int i = 0; i < N1; i++) {
            for (int j = 0; j < M2; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
