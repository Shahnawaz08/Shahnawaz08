package array.TwoDArray;

import java.util.Arrays;
import java.util.Scanner;

public class P7_ColumnSum {
    public static int[] solve(int[][] A) {
        int [] colsum=new int[A[0].length];
        int idx=0;
        for(int j=0;j<A[0].length;j++){
            int sum=0;
            for(int i=0;i<A.length;i++){
                sum+=A[i][j];
            }
            colsum[idx]=sum;
            idx++;
        }
        return colsum;
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
        int [] colsum=solve(A);
        System.out.println(Arrays.toString(colsum));

    }
}
