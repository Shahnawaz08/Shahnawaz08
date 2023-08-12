package HashingProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/*
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.
 */

public class P9_SubarraywithGivenSum {
    public static int[] solve(int[] A, int B) {
        HashMap<Long,Integer>h1=new HashMap<Long, Integer>();
        long sum=0;
        h1.put(sum,-1);
        int startindex=-1;
        int endindex=-1;
        int flag=0;
        for(int i=0;i<A.length&&flag==0;i++){
            sum+=A[i];
            for(long k:h1.keySet()){
                if(sum-k==B && h1.containsKey(k)){
                    startindex=h1.get(k);
                    endindex=i;
                    flag=1;
                    break;

//                    System.out.println(startindex+" "+endindex);

                }
            }
            //System.out.println(h1);
            h1.put(sum,i);
        }
        System.out.println(startindex+" "+endindex);
        int [] arr=new int[endindex-startindex];
        int idx=0;
        if(startindex==-1&&endindex==-1){
            return arr;
        }
        for(int i=startindex+1;i<=endindex;i++){
            arr[idx]=A[i];
            idx++;
        }
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
        System.out.println("Size of Window  ");
        int B=sc.nextInt();
        int [] noOfDistictElement=solve(A,B);
        System.out.println(Arrays.toString(noOfDistictElement));

    }
}
