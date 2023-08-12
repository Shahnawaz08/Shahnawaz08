package bits_manupulation;
/*
Problem Description
Richard Hendricks, a mastermind in compression algorithms, is an employee of Hooli in Silicon Valley.
One day, he finally decided to quit and work on his new idea of the middle-out compression algorithm.
He needed to work at the bit - level to compress data. He, eventually, encountered this problem.
There is an array A of N integers. He has to perform certain operations on the elements.
In any one operation, two indices i and j (i < j) are chosen, and A[i] is replaced with A[i] & A[j],
and A[j] is replaced with A[i] | A[j], where & represents the Bitwise AND operation and | represents the Bitwise OR operation.
This operation is performed over all the pairs of integers in the array.

Help Richard find the Bitwise XOR of all the elements after performing the operations.
 */

import java.util.Arrays;
import java.util.Scanner;

public class P2_BitCommersor {
    public static  int compressBits(int[] A) {
        for(int i=0;i<A.length-1;i++){
            int a=A[i];
            int b=A[i+1];
            A[i]=a&b;
            A[i+1]=a|b;
        }
        System.out.println(Arrays.toString(A));
        int no=0;
        for(int i=0;i<A.length;i++){
            no=no^A[i];
        }
        return no;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Size of an array ");
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
       int compNo=compressBits(arr) ;
        System.out.println("Compressed number is "+compNo);
    }
}
