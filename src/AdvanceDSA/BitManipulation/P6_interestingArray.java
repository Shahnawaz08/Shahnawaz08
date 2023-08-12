package AdvanceDSA.BitManipulation;

import java.util.Scanner;

/*
You have an array A with N elements. We have two types of operation available on this array :
We can split an element B into two elements, C and D, such that B = C + D.
We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 0 after several splits and/or merge?
 */
public class P6_interestingArray {
    public static String solve(int[] A) {
        long sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
        }
        if(sum%2==0){
            return "Yes";
        }
        return "No";
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr =new int[N];
        for (int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        String is=solve(arr);
        System.out.println(is);
    }
}
