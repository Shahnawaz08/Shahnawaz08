package HashingProblems;
/*
Shaggy has an array A consisting of N elements.
We call a pair of distinct indices in that array a special if elements
at those indices in the array are equal.

Shaggy wants you to find a special pair such that the distance between
that pair is minimum. Distance between two indices is defined as |i-j|.
If there is no special pair in the array, then return -1.

Problem Constraints
1 <= |A| <= 105
 */

import java.util.HashMap;
import java.util.Scanner;

public class P16_ShaggyandDistance {
    public static int solve(int[] A) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int mindist=Integer.MAX_VALUE;
        for (int i=0;i<A.length;i++){
            if(hm.containsKey(A[i])){
                int j=hm.get(A[i]);
                int min=i-j;
                mindist=Math.min(min,mindist);
            }
            else {
                hm.put(A[i],i);
            }
        }
        if(mindist==Integer.MAX_VALUE){
            return -1;
        }
        return mindist;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int no=solve(arr);
        System.out.println("Longest conecutive number "+no);
    }
}
