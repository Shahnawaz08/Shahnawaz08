package HashingProblems;
/*
Given an array A of N integers.
Find the largest continuous sequence in a array which sums to zero.

Problem Constraints
1 <= N <= 106
-107 <= A[i] <= 107
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P18_largestContSeqZeroSum {
    public static int[] lszero(int[] A) {
        int N=A.length;
        HashMap<Long,Integer> hm=new HashMap<>();
        long [] ps=new long[N];
        ps[0]=A[0];
        hm.put(ps[0],0);
        int s=-1;
        int e=-1;
        int maxdist=-1;
        for(int i=1;i<N;i++){
            ps[i]=A[i]+ps[i-1];
            if(hm.containsKey(ps[i])){
                int j=hm.get(ps[i]);
                int len=i-j;
                if(maxdist<len){
                    maxdist=len;
                    s=j+1;
                    e=i;
                }
            }
            else if(ps[i]==0){
                int len=i+1;
                if(maxdist<len){
                    maxdist=len;
                    s=0;
                    e=i;
                }
            }
            else {
                hm.put(ps[i],i);
            }

        }
        if(s==-1 &&e==-1 &ps[0]==0){
            int [] arr={0};
            return arr;
        }
        if(s==-1&&e==-1){
            int [] arr={};
            return arr;
        }
        int [] arr=new int[e-s+1];
        int k=0;
        //System.out.println(s +" "+e);
        for (int i=s;i<=e;i++){
            arr[k]=A[i];
            k++;
        }
        return arr;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int []no=lszero(arr);
        System.out.println(Arrays.toString(no));
    }
}
