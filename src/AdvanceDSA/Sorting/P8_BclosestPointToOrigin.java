package AdvanceDSA.Sorting;

import java.util.Arrays;

public class P8_BclosestPointToOrigin {
    public static int[][] solve(int[][] A, int B) {
        Arrays.sort(A,(int [] a, int [] b)-> (a[0]*a[0]+a[1]*a[1]-b[0]*b[0]-b[1]*b[1]));
        int [][] arr=new int[B][2];
        for(int i=0;i<B;i++){
            arr[i][0]=A[i][0];
            arr[i][1]=A[i][1];
        }
        return arr;

    }
}
