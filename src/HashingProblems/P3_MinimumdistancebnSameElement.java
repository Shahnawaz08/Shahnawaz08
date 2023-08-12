package HashingProblems;
/*
Shaggy has an array A consisting of N elements. We call a pair of distinct indices
in that array a special if elements at those indices in the array are equal.
Shaggy wants you to find a special pair such that the distance between that pair is minimum.
Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class P3_MinimumdistancebnSameElement {
    public static int solve(int[] A) {
        int min=Integer.MAX_VALUE;
        HashMap<Integer,Integer> h1=new HashMap<>();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            if(h1.containsKey(A[i])){
                int index=h1.get(A[i]);
                int dis=i-index;
                min= Math.min(min,dis);
                h1.put(A[i],i);
            }
            else{
                h1.put(A[i],i);
            }
        }
        if(min==Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size and element");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }

        int mindistance=solve(A);
        System.out.println(mindistance);


    }
}
