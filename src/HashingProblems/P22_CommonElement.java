package HashingProblems;/*
Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.


Problem Constraints
1 <= N, M <= 105

1 <= A[i] <= 109
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class P22_CommonElement {
        public static  int[] solve(int[] A, int[] B) {
                HashMap<Integer,Integer> hm=new HashMap<>();
                /*
                for(int i:A){
                       hm.put(i,hm.getOrDefault(i,0)+1) ;

                }

                 */
                for(int i:A){
                        if(hm.containsKey(i)){
                                hm.put(i,hm.get(i)+1);
                        }
                        else{
                                hm.put(i,1);
                        }

                }
                //System.out.println(hm);
                ArrayList<Integer> arr=new ArrayList<>();
                for(int i:B){
                        if(hm.containsKey(i)){
                                arr.add(i);
                                if(hm.get(i)==1){
                                        hm.remove(i);
                                }
                                else {
                                        hm.put(i, hm.get(i) - 1);
                                }
                        }
                }
                int [] comArray=arr.stream().mapToInt(i -> i).toArray();
                Arrays.sort(comArray);
                return comArray;
        }
        public static void main(String[] args) {
                Scanner sc=new Scanner(System.in);
                System.out.println("Enter size of an array A followed by elements ");
                int N=sc.nextInt();

                int [] A=new int[N];
                for(int i=0;i<N;i++){
                        A[i]=sc.nextInt();
                }
                System.out.println("Enter size of an array B followed by elements ");
                int M=sc.nextInt();
                int [] B=new int[M];
                for(int i=0;i<M;i++){
                        B[i]=sc.nextInt();
                }
                int [] commemt=solve(A,B);
                System.out.println("Common elements are "+ Arrays.toString(commemt));
        }
}
