package HashingProblems;
/*
Given two integer arrays, A and B of size N and M, respectively.
Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class P2_CommonElementInTwoArray {
    public static int[] solve(int[] A, int[] B) {
        HashMap<Integer,Integer> h1=new HashMap<>();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int elm:A){
            if(h1.containsKey(elm)){
                int freq=h1.get(elm);
                h1.put(elm,freq+1);
            }
            else{
                h1.put(elm,1);
            }
        }
        for(int d:B){
            if(h1.containsKey(d)&&h1.get(d)>0){
                arr.add(d);
                h1.put(d,h1.get(d)-1);
            }
        }
        //System.out.println(h1);
        //System.out.println(arr);
        int [] ar=arr.stream().mapToInt(i -> i).toArray();
        return ar;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size and element");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("enter size and element");
        int M=sc.nextInt();
        int [] B=new int[N];
        for(int i=0;i<N;i++) {
            B[i] = sc.nextInt();
        }
        int [] commonelement=solve(A,B);
        System.out.println(Arrays.toString(commonelement));


    }

}
