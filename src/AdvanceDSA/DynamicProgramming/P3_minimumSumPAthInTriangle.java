package AdvanceDSA.DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;
/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

Adjacent numbers for jth number of row i is jth and (j+1)th numbers of row i+1 is



Problem Constraints
|A| <= 1000

A[i] <= 1000
 */

public class P3_minimumSumPAthInTriangle {
    public static int getmin(int i,int j,int N,ArrayList<ArrayList<Integer>> a,ArrayList<ArrayList<Integer>> dp){
            //base case
            if(i==N){
                return 0;
            }
            if(j>i){
                return Integer.MAX_VALUE;
            }
            if(dp.get(i).get(j)!=-1){
                return dp.get(i).get(j);
            }
            //recursive case
            int sum=a.get(i).get(j);
            int down=getmin(i+1,j,N,a,dp);
            int right=getmin(i+1,j+1,N,a,dp);
            int path=Math.min(down,right);
            int mincost=sum+path;
            dp.get(i).add(j,mincost);
            return sum+path;

    }
    public static int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int N=a.size();
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        for (ArrayList<Integer> integers : a) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < integers.size(); j++) {
                temp.add(-1);
            }
            dp.add(temp);

        }
       // System.out.println(dp);
        int min=getmin(0,0,N,a,dp);
       // System.out.println(dp);
        return min;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        for(int i=0;i<N;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            int no=sc.nextInt();
            while (no!=-1){
                temp.add(no);
                no=sc.nextInt();
            }
            arr.add(temp);
        }
        int no=minimumTotal(arr);
        System.out.println("Number of A digit number whose sum is b is "+no);
    }
}
