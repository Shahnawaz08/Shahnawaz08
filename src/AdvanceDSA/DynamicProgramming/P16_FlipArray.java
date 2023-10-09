package AdvanceDSA.DynamicProgramming;
/*
Given an array A of positive elements, you have to flip the sign of some of its elements
such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).

Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.



Problem Constraints

1 <= length of(A) <= 100

Sum of all the elements will not exceed 10,000.



Input Format

First and only argument is an integer array A.



Output Format

Return an integer denoting the minimum number of elements whose sign needs to be flipped.



Example Input

Input 1:

 A = [15, 10, 6]
Input 2:

 A = [14, 10, 4]


Example Output

Output 1:

 1
Output 2:

 1

 */

import java.util.Arrays;
import java.util.Scanner;

class node{
    int sum=0;
    int flip=0;
    public node(int sum,int flip){
        this.sum=sum;
        this.flip=flip;
    }

}

public class P16_FlipArray {



    public static int solve(final int[] A) {
        int count=0;
        if(A.length==1){
            return 0;
        }
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
        }
        int [] arr=Arrays.copyOf(A, A.length);

        node numOFFlip=helperFun(arr,0,0);
       // System.out.println("final "+Arrays.toString(arr));
        return numOFFlip.flip;

    }

    private static node helperFun(int[] A, int flip, int i) {
        //System.out.println("Include sum "+sum+" flip "+flip+" index "+i);
        int sum=0;
        for(int id=0;id<A.length;id++){
            sum+=A[id];
        }
        if(i==A.length ||sum<0){
            return new node(sum,flip);
        }

        node include=helperFun(A,flip,i+1);
       // System.out.println(Arrays.toString(A)+ "Include sum "+sum+" flip "+flip+" index "+i);
        int [] arr=Arrays.copyOf(A, A.length);
        arr[i]=-arr[i];
        node exclude=helperFun(arr,flip+1,i+1);
       // System.out.println(Arrays.toString(arr)+"exclude sum "+sum+" flip "+(flip+1)+" index "+i);
        A[i]=-A[i];
        if(include.sum==exclude.sum){
            if(include.flip<exclude.flip){
                return include;
            }
            else {
                return exclude;
            }
        } else  {
            if(include.sum<exclude.sum){
                return include;
            }
            else {
                return exclude;
            }

        }


    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //length of the input array
        int n=sc.nextInt();
        //define an array
        int [] A=new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }

        int noOFflip=solve(A);
        System.out.println("Number of element to be flip to get the minimum non negative number is "+noOFflip);
    }
}
