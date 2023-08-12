package AdvanceDSA.Backtracking;
/*
Problem Description
Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.

The same repeated number may be chosen from A unlimited number of times.

Note:

1) All numbers (including target) will be positive integers.

2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
3) The combinations themselves must be sorted in ascending order.
4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
5) The solution set must not contain duplicate combinations.



Problem Constraints
1 <= |A| <= 20

1 <= A[i] <= 50

1 <= B <= 500
 */

import java.util.*;

public class P8_CombinationSum {
    static ArrayList<Integer> temp;
    public static void dfsrecursion(int [] A,int sum,int start,int N,ArrayList<ArrayList<Integer>> arr){
        if(start==N){
            if(temp.size()>0&&sum==0){
                //System.out.println(temp);
                ArrayList<Integer> temp1=new ArrayList<>(temp);
                Collections.sort(temp1);
                arr.add(temp1);
            }
            return;
        }
        if(A[start]<=sum){
            temp.add(A[start]);
            dfsrecursion(A,sum-A[start],start,N,arr);
            temp.remove(temp.size()-1);
        }

        dfsrecursion(A,sum,start+1,N,arr);
        return;
    }
    static final class ListComparator implements Comparator< ArrayList < Integer >> {
        @
                Override
        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            // do other error checks here as well... such as null. outofbounds, etc
           // System.out.println("ouside");
            if (o1.equals(o2)) return 0;
            for(int i=0;i<o1.size();i++){
                //System.out.println("Inside");
                if(i>=o2.size()){
                    break;
                }
                  if(o1.get(i)>o2.get(i)) {
                      //System.out.println("hii");
                      return 1;
                  }
                  if(o1.get(i)<o2.get(i)) return 0;

            }
            return 0;
        }
    }
     public static int[][] combinationSum(int[] A, int B) {
         ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
         //int i=0;
         int N=A.length;
         temp=new ArrayList<>();
         dfsrecursion(A,B,0,N,arr);
         //System.out.println(arr);
         int [][] candidateArray=new int[arr.size()][];
         Collections.sort(arr, new ListComparator());
         int idx=0;
         for(ArrayList<Integer> temp:arr){
             candidateArray[idx]=temp.stream().mapToInt(i->  i).toArray();
             idx++;
         }
         return candidateArray;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array followed by the elements");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter the sum ");
        int B=sc.nextInt();
        int [][] candArray=combinationSum(A,B);
        for(int i=0;i<candArray.length;i++){
            System.out.println(Arrays.toString(candArray[i]));
        }
    }
}
