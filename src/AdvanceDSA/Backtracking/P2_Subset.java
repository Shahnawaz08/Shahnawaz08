package AdvanceDSA.Backtracking;
/*
Given a set of distinct integers A, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.


Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P2_Subset {
    static int [][] twoDArray;
    static int row;
    public static int fact(int n){
        int fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }
    public static boolean compare(int [] a,int [] b){
//        return a<b; for decending
        int l1=a.length;
        int l2=b.length;
        int min=l1<l2?l1:l2;
        for(int i=0;i<min;i++){
            if(a[i]<b[i]){
                return false;
            }
            if(a[i]>b[i]){
                return true;
            }
        }
        if(l1<l2){
            return false;
        }
        return true;
    }
    public static void bubbleSortArrays(int [][] arr){
        int n=arr.length;
        for(int itr=1;itr<=n-1;itr++){
            for(int j=0;j<=n-itr-1;j++){
                //if(arr[j]>arr[j+1]){
                if(compare(arr[j],arr[j+1])){
                    int [] temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void generateSubset(int [] input,int i,ArrayList<Integer> output){
        //Base case
        if(i==input.length){
            int [] temp=output.stream().mapToInt(j->j).toArray();
            twoDArray[row]=temp;
            row++;
            return;
        }
        //Recursion case
        generateSubset(input,i+1,output);
        output.add(input[i]);
        generateSubset(input,i+1,output);
        int index=output.size()-1;
        output.remove(index);
    }
    public static int [][] subset(int []A){
        int N=A.length;
        int totalRows=(int)Math.pow(2,N);
        row=0;
        twoDArray=new int[totalRows][];
        ArrayList<Integer> arr=new ArrayList<>();
        generateSubset(A,0,arr);
        bubbleSortArrays(twoDArray);
        return twoDArray;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int []A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int [][] res=subset(A);
        System.out.println(Arrays.deepToString(res));
    }
}
