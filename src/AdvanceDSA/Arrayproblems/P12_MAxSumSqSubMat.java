package AdvanceDSA.Arrayproblems;

import java.util.Scanner;

public class P12_MAxSumSqSubMat {
    public static int solve(int[][] A, int B) {
        int N=A.length;
        int M=A[0].length;
        int [][] ps=new int[N][M];
        //prefix sum matrix
        ps[0][0]=A[0][0];
        for (int i=1;i<N;i++){
            ps[i][0]=ps[i-1][0]+A[i][0];
        }
        for (int j=1;j<M;j++){
            ps[0][j]=ps[0][j-1]+A[0][j];
        }
        for (int i=1;i<N;i++){
            for(int j=1;j<M;j++){
                ps[i][j]=ps[i-1][j]+ps[i][j-1]-ps[i-1][j-1]+A[i][j];
            }
        }
        //System.out.println(Arrays.deepToString(ps));
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<=N-B;i++) {
            for (int j = 0; j <= N - B; j++) {
                int x1 = i;
                int y1 = j;
                int x2 = i+B-1;
                int y2 = j+B-1;
                int sum=0;
                if (x1 != 0 && y1 != 0) {
                    sum = ps[x2][y2] - ps[x1 - 1][y2] - ps[x2][y1 - 1] + ps[x1 - 1][y1 - 1];
                } else if (x1 == 0 && y1 == 0) {
                    sum = ps[x2][y2];
                } else if (y1 == 0) {
                    sum = ps[x2][y2] - ps[x1 - 1][y2];
                } else {
                    sum = ps[x2][y2] - ps[x2][y1 - 1];
                }
                if(sum>maxsum){
                    maxsum=sum;
                }
            }
        }


        return maxsum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int [][] arr=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("Element to be found");
        int B= sc.nextInt();

        int index_val=solve(arr,B);
        System.out.println(index_val);
    }
}
