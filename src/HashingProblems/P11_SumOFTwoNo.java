package HashingProblems;
/*
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based.
Put both these numbers in order in an array and return the array from your function ( Looking at the function
signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2,
choose the one with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P11_SumOFTwoNo {
    public static int[] twoSum(final int[] A, int B) {
        HashMap<Integer,Integer> h1=new HashMap();
        int femt=-1;
        int semt=-1;
        for(int i=0;i<A.length;i++){
            int k=B-A[i];
            if(h1.containsKey(k)){
                femt=h1.get(k);
                semt=i;
                break;

            }
            h1.put(A[i],i);
        }
        if(femt==-1 && semt==-1){
            int []arr=new int[0];
            return arr;
        }
        int [] arr=new int[2];
        arr[0]=A[femt];
        arr[1]=A[semt];
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size and element");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("enter the required sum  ");
        int B=sc.nextInt();
        int [] Elements=twoSum(A,B);
        System.out.println(Arrays.toString(Elements));

    }
}
