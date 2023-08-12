package HashingProblems;
/*
Given an integer array A containing N distinct integers.

        Find the number of unique pairs of integers in the array whose XOR is equal to B.

        NOTE:

        Pair (a, b) and (b, a) is considered to be the same and should be counted once.

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P13_XorofTWoNUmber {
    public static int solve(int[] A, int B) {
        int count=0;
        HashSet<Integer> h1=new HashSet<>();
        for(int i=0;i<A.length;i++){
            int thirdno=B^A[i];
            if(h1.contains(thirdno)){
                count++;
            }
            h1.add(A[i]);
        }
        return count;
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
        int noOfUniqPair = solve(A, B);
        System.out.println("No of unique pair whose xor is "+B+" is "+noOfUniqPair);
    }
}
