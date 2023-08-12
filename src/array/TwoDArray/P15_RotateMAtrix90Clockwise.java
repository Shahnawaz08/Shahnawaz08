package array.TwoDArray;

import java.util.Arrays;
import java.util.Scanner;

public class P15_RotateMAtrix90Clockwise {
    public static void solve(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= i; j++) {
               int temp=A[i][j];
               A[i][j]=A[j][i];
               A[j][i]=temp;
            }
        }
        for (int[] a : A) {
            System.out.println(Arrays.toString(a));
        }
        for(int i=0;i<A.length;i++){
            for(int j=0;j<(A.length)/2;j++){
                int temp=A[i][j];
                A[i][j]=A[i][A.length-j-1];
                A[i][A.length-j-1]=temp;
            }
        }
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of matrix ");
        int A = sc.nextInt();
        int[][] matrix = new int[A][A];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        //int[][] dret = new int[A * A - 1][A];
        solve(matrix);
        for (int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }

    }
}
