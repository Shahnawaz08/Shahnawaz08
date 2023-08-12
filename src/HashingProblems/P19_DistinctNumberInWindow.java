package HashingProblems;
/*
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class P19_DistinctNumberInWindow {
    public static int[] dNums(int[] A, int B) {
        if(B>A.length){
            return new int[]{};
        }
        HashMap<Integer,Integer> hm=new HashMap<>();
        int s=0;
        int e=0;
        while (e<B){
            hm.put(A[e],hm.getOrDefault(A[e],0)+1);
            e++;
        }
        int [] numArray=new int[A.length-B+1];
        int idx=0;
        numArray[idx]=hm.size();
        idx++;
        while (e<A.length){
            hm.put(A[e],hm.getOrDefault(A[e],0)+1);
            if(hm.get(A[s])==1){
                hm.remove(A[s]);
            }
            else {
                hm.put(A[s],hm.get(A[s])-1);
            }
            numArray[idx]=hm.size();
            idx++;
            e++;
            s++;


        }
        return numArray;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter size of a window");
        int B=sc.nextInt();
        int []no=dNums(arr,B);
        System.out.println(Arrays.toString(no));
    }
}
