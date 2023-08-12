package array.IntermidiateArrays;
import java.lang.*;
import java.util.*;

public class P1_ArrayRotateBtimes {
    public static void reverse(int[] A,int N){
        for(int i=0;i<N/2;i++){
            int temp=A[i];
            A[i]=A[N-i-1];
            A[N-i-1]=temp;
        }

    }
    public static void reverse(int[] A,int B,int N){

        int mid=(B+N)/2;
        for(int i=0;(i+B)<mid;i++){
            int temp=A[B+i];
            A[B+i]=A[N-i-1];
            A[N-i-1]=temp;
        }

    }

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] A=new int[N];
        for(int x=0;x<N;x++){
            A[x]=sc.nextInt();
        }
        System.out.println(Arrays.toString(A));

        reverse(A,N);
        System.out.println(Arrays.toString(A));
        int B=sc.nextInt();
        B=B%N;
        reverse(A,B);
        System.out.println(Arrays.toString(A));
        reverse(A,B,N);
        System.out.println(Arrays.toString(A));

    }
}
