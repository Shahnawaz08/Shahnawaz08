package AdvanceDSA.TwoPointers;
/*
Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0
Find all unique triplets in the array which gives the sum of zero.
Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.

Problem Constraints

0 <= N <= 7000

-108 <= A[i] <= 108
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class P7_3SumZero {
    public static int[][] threeSum(int[] A) {
        //sort the array
        Arrays.sort(A);
        //creating hastset of arraylist to store unique arraylist;
        HashSet<ArrayList<Integer>> hs=new HashSet<ArrayList<Integer>>();
        int N=A.length;//size of an array
        //adding element of an array to  new hashset to get them in O(1);
        HashSet<Integer> ArrayHS=new HashSet<>();
        //traverse middle element
        for(int i=1;i<N-1;i++){
            int b=A[i];
            int remsum=-b;
            int s=0;
            int e=N-1;
            while (s<i &&e>i){
                int a=A[s];
                int c=A[e];
                long sum=(long) a+c;
                if(sum==remsum){
                    ArrayList<Integer> temp=new ArrayList<>(Arrays.asList(a,b,c));
                    hs.add(temp);
                    s++;
                    e--;
                }
                else if(sum>remsum){
                    e--;
                }
                else {
                    s++;
                }

            }

        }
        //System.out.println(hs);
        int sizeOfTwoDarray=hs.size();
        int [][] twoDarray=new int[sizeOfTwoDarray][3];
        int index=0;
        for(ArrayList temp:hs){
            twoDarray[index]=temp.stream().mapToInt(i-> (int)i).toArray();
            index++;
        }
        return twoDarray;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array followed by the elements");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int [][] triplets=threeSum(A);
        for (int[] triplet : triplets) {
            System.out.println(Arrays.toString(triplet));
        }
    }
}
