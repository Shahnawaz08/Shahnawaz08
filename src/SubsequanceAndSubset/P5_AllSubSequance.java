package SubsequanceAndSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/*
Given a set of distinct integers A, return all possible subsets.
NOTE:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
 */

public class P5_AllSubSequance {
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
    public static int[][] subsets(int[] A) {
        int size=A.length;

        int len=(A.length*A.length+A.length)/2;
        ArrayList<ArrayList<Integer>> subarray=new ArrayList<>();

        int binary=1<<size;
        System.out.println(size);
        System.out.println(binary);
        for(int i=0;i<binary;i++){
            ArrayList<Integer> subset=new ArrayList<>();
            int temp=i;
            int index=size-1;
            while(temp>0){
                int set=temp&1;
                temp=temp>>1;
                if(set==1){
                   subset.add(A[index]);
                }
                index--;
            }
            //System.out.println(subarray);
            Collections.sort(subset);
            subarray.add(subset);
            //System.out.println(subarray.get(i));
        }
        int N=subarray.size();
        //int [][] arr=new int[N][5];
        int [][] arr=new int[N][];
        for(int i=0;i<N;i++){
            int sizeofitharray=subarray.get(i).size();
            int [] singlrarray=new int[sizeofitharray];
            for(int j=0;j<subarray.get(i).size();j++){
               singlrarray[j]=subarray.get(i).get(j);
               // arr[i][j]=subarray.get(i).get(j);
            }
            arr[i]=singlrarray;
        }
        bubbleSortArrays(arr);

        return arr;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int [][] sub=subsets(A);
        System.out.println(Arrays.deepToString(sub));

    }
}
