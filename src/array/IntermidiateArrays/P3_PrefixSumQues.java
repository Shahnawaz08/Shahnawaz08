package array.IntermidiateArrays;
import java.util.Arrays;
import java.util.Scanner;


/*You are given an integer array A of length N.
        You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
        For each query, you have to find the sum of all elements from L to R indices in A (1 - indexed).
        More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.

 */

public class P3_PrefixSumQues {

        public static  long[] rangeSum(int[] A, int[][] B) {
            long[] ps=new long[A.length];
            ps[0]=A[0];
            for(int i=1;i<A.length;i++){
                ps[i]=ps[i-1]+A[i];
            }
            long []psrern=new long[B.length];
            for(int i=0;i<B.length;i++){
                if(B[i][0]==1){
                    psrern[i]=ps[B[i][1]-1];
                }
                else{
                    long l=ps[B[i][0]-2];
                    long e=ps[B[i][1]-1];
                    psrern[i]=e-l;

                }
            }
            return psrern;
        }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("enter size of an array");
        int [] A=new int[n];
        System.out.println("Enter element of an array");
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("enter size of a 2D array");
        int rows =sc.nextInt();
        //int cols =sc.nextInt();
        int cols=2;
        int[][] arr=new int[rows][cols];
        System.out.println("Enter element of a 2D  array");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        long [] sum=rangeSum(A,arr);
        System.out.println(Arrays.toString(sum));

    }



}
