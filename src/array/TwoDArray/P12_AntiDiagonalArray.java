package array.TwoDArray;
import java.util.Arrays;
import java.util.Scanner;

public class P12_AntiDiagonalArray {
    public static int[][] diagonal(int[][] A) {
        int N = A.length;
        int M=N * N - 1;
        int[][] D = new int[M][N];
        int count = 0;
        int rmin = 0;
        int cmin = 0;
        int rmax = N;
        int cmax = N;
        for (int j = 0; j < N; j++) {
            int k = rmin;
            for (int i = cmin; i < cmax; i++) {
                D[k][j] = A[rmin][i];

              //  System.out.println(A[rmin][i]);
                k++;
            }
           // System.out.println("jj");

            rmin++;

            for (int i = rmin; i < rmax; i++) {
                D[k][j] = A[i][cmax-1];
                k++;
               // System.out.println("hi");
            }
            cmax--;

        }
        return D;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of matrix ");
        int A = sc.nextInt();
        int[][] dmatrix = new int[A][A];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                dmatrix[i][j] = sc.nextInt();
            }
        }
            int[][] dret = new int[A * A - 1][A];
            dret = diagonal(dmatrix);
            for (int[] a : dret) {
                System.out.println(Arrays.toString(a));
            }

        }
    }

