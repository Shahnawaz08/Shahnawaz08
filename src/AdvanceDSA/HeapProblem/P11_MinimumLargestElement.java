package AdvanceDSA.HeapProblem;
/*
Given an array A of N numbers, you have to perform B operations. In each operation, you have to pick any one of the N elements and add the original value(value stored at the index before we did any operations) to its current value. You can choose any of the N elements in each operation.

Perform B operations in such a way that the largest element of the modified array(after B operations) is minimized.
Find the minimum possible largest element after B operations.



Problem Constraints
1 <= N <= 106
0 <= B <= 105
-104 <= A[i] <= 104



Input Format
The first argument is an integer array A.
The second argument is an integer B.



Output Format
Return an integer denoting the minimum possible largest element after B operations.



Example Input
Input 1:

 A = [1, 2, 3, 4]
 B = 3
Input 2:

 A = [5, 1, 4, 2]
 B = 5


Example Output
Output 1:

 4
Output 2:

 5


Example Explanation
Explanation 1:

 Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
 Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
 Minimum possible largest element after 3 operations is 4.
Explanation 2:

 Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
 Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
 Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
 Minimum possible largest element after 5 operations is 5.
 */

import java.util.*;

public class P11_MinimumLargestElement {
    static class Pair{
        int value;
        int idx;
        public Pair(int value,int idx) {
            this.value = value;
            this.idx=idx;
        }

    }
    public static int solve(int[] A, int B){
        Comparator<Pair> PairComparator = Comparator.comparingInt(c -> c.value);

        PriorityQueue<Pair> pq=new PriorityQueue<>(PairComparator);
        int n=A.length;
        int [] stateArray=new int[n];
        for(int i=0;i<n;i++){
            stateArray[i]=A[i];
        }


        while (B>0){
            for(int i=0;i<n;i++){
                int nextvalue=stateArray[i]+A[i];
                pq.add(new Pair(nextvalue,i));
            }

            Pair p=pq.poll();
            int indexofminnext=p.idx;
            int val=p.value;
            stateArray[indexofminnext]=val;
            int nextvalue=val+A[indexofminnext];
//            pq.add(new Pair(nextvalue,indexofminnext));
            B--;
            System.out.println("queue element ");
            System.out.println(p.idx+" "+p.value);
            while (!pq.isEmpty()){
                Pair pp=pq.poll();
                System.out.println(pp.idx+" "+pp.value);
                pq.add(pp);
            }
            System.out.println("=====================================");


//            pq.clear();


        }
        System.out.println("=====================================");
        System.out.println(Arrays.toString(stateArray));

        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int B= sc.nextInt();
        int minelement=solve(A ,B);
        System.out.println("Minimum of maximum element possible after "+B+" operations is "+minelement);
    }
}
