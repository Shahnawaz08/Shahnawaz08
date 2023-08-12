package HashingProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
NOTE: if B > N, return an empty array.
 */
public class P8_DistinctNUmberInAWindow {
    public static int[] dNums(int[] A, int B) {
        int [] distemtArray=new int[A.length-B+1];
        HashMap<Integer,Integer> h1=new HashMap<>();
        for(int i=0;i<B;i++){
            int freq=h1.getOrDefault(A[i],0);
            h1.put(A[i],freq+1);
        }
        int idx=0;
        distemtArray[idx]=h1.size();
        idx++;
        int r=B;
        for(int l=1;l<=A.length-B;l++){
            h1.put(A[l-1],h1.get(A[l-1])-1);
            if(h1.get(A[l-1])==0){
                h1.remove(A[l-1]);
            }
            h1.put(A[r],h1.getOrDefault(A[r],0)+1);
            System.out.println(h1);
            distemtArray[idx]=h1.size();
            idx++;
            r++;
        }
        return distemtArray;
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
        int [] noOfDistictElement=dNums(A,B);
        System.out.println(Arrays.toString(noOfDistictElement));

    }
}
