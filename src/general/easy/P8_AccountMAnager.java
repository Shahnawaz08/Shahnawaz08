package general.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
Problem Description

We want to stimulate a simple order dispatch module. We have A different accounts/ connections with the exchange. At any point in time, we can send an order via an account if it is in “available” mode. The account goes in “busy” mode for B microseconds after sending an order successfully.

We are given a list C of timestamps of the orders where C[i] denotes that an order was placed at C[i] microseconds. The timestamps are given in increasing order of time. For each timestamp entry, we need to find the number of accounts available after sending this particular order. If no account is available before sending the order, the answer is 0.



Problem Constraints

1 <= A <= 105

1 <= B <=104

1 <= |C| <=105

0 <= C[i] <= 109



Input Format

The first line of input contains A.

The second line of input contains B.

The third line contains an integer array C denoting the timestamps.



Output Format

Return an integer array, the ith element of which is equal to the number of accounts available after sending this particular order.


Example Input

Input 1:

  A = 4
  B = 5
  C = [0, 1, 6, 11]
Input 2:

  A = 2
  B = 100
  C = [0, 1, 5]


Example Output

Output 1:

  [3, 2, 3, 3]
Output 2:

  [1, 0, 0]
 */

public class P8_AccountMAnager {
    public static int[] solveBrute(int A, int B, int[] C) {
        int [] sub=new int [C[C.length-1]+1+B];
        int [] res=new int [C.length];
        for(int i=0;i<C.length;i++){
            if(A+sub[C[i]]>0) {
//                if(i==4){
//                    System.out.println("hii");
//                }
                for (int j = 0; j < B; j++) {
                    sub[C[i] + j]--;
                }
            }
        }
        System.out.println(Arrays.toString(sub));
        for(int i=0;i<C.length;i++){
            res[i]=sub[C[i]]+A;
        }

        return res;
    }

    public static int[] solve(int A, int B, int[] C) {

        int [] res=new int [C.length];
        Queue<Integer> qu=new LinkedList<>();
        for(int i=0;i<C.length;i++){
            if(!qu.isEmpty()){
                while (!qu.isEmpty()&&qu.peek()<=C[i]){
                    qu.poll();
                }
            }
            if(A-qu.size()>0){
                res[i]=A-qu.size()-1;
                qu.add(C[i]+B);
            }
        }


        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        int N= sc.nextInt();
        int [] C=new int[N];
        for(int i=0;i<N;i++){
            C[i]=sc.nextInt();
        }
        int [] res=solve(A,B,C);
        System.out.println(Arrays.toString(res));
    }
}
