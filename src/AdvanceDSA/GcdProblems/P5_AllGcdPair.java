package AdvanceDSA.GcdProblems;

import java.util.Arrays;
import java.util.Scanner;
/*
Given an array of integers A of size N containing GCD of every possible pair of elements of another array.
Find and return the original numbers used to calculate the GCD array in any order. For example, if original
 numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.
 */

public class P5_AllGcdPair {
    static int gcd(int a, int b)
    {
        if (b == 0)
        {
            return a;
        }
        return gcd(b, a % b);

    }
    public static void reverse(int[] input)
    {
        int last = input.length - 1;
        int middle = input.length / 2;
        for (int i = 0; i <= middle; i++)
        {
            int temp = input[i];
            input[i] = input[last - i];
            input[last - i] = temp;
        }
    }
    public static int[] solve(int[] A) {
        int N=A.length;
        Arrays.sort(A);
        reverse(A);
        int freq[] = new int[A[0] + 1];

        // Count frequency of each element
        for (int i = 0; i < N; i++)
        {
            freq[A[i]]++;
        }

        // Size of the resultant array
        int size = (int) Math.sqrt(N);
        int brr[] = new int[size], x, l = 0;

        for (int i = 0; i < N; i++)
        {
            if (freq[A[i]] > 0 && l < size)
            {

                // Store the highest element in
                // the resultant array
                brr[l] = A[i];

                // Decrement the frequency of that element
                freq[brr[l]]--;
                l++;
                for (int j = 0; j < l; j++)
                {
                    if (i != j)
                    {

                        // Compute GCD
                        x = gcd(A[i], brr[j]);

                        // Decrement GCD value by 2
                        freq[x] -= 2;
                    }
                }
            }
        }
        return brr;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int [] A=new int[N];
        for (int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }

        int []arr=solve(A);
        System.out.println(Arrays.toString(arr));
    }
}
