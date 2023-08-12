package array.TwoDArray;

import java.util.Scanner;

public class P13_Equalmatrix {
    public static int solve(int[][] A, int[][] B) {
        int n1=A.length;
        int m1=A[0].length;
        int n2=B.length;
        int m2=B[0].length;
        if(n1!=n2 || m1!=m2){
            return 0;
        }
        for(int i=0;i<n1;i++){
            for(int j=0;j<m2;j++){
                if(A[i][j]!=B[i][j]){
                    return 0;
                }
            }
        }
        return 1;
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
        int x=solve(A,B);
        System.out.println(x);

    }
}
