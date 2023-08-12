package HashingProblems;
/*
Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j
such that A[i] - A[j] = k, i != j.

Example :
Input :
A : [1 5 3]
k : 2
Output :
1
as 3 - 1 = 2
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class P12_DiffOfTwo {
    public static int diffPossible(final int[] A, int B) {
        HashSet<Integer> h1=new HashSet<>();
        for(int i=0;i<A.length;i++){
            int k=B+A[i];
            int l=A[i]-B;
            if(h1.contains(k)||h1.contains(l)){
                return 1;
            }
            h1.add(A[i]);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size and element");
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println("enter the required sum  ");
        int B = sc.nextInt();
        int exit = diffPossible(A, B);
        if (exit == 1) {
            System.out.println("Numbers exist such that diff  is" + B);
        } else {
            System.out.println("Donot exist such number whose difference is " + B);
        }
    }
}
