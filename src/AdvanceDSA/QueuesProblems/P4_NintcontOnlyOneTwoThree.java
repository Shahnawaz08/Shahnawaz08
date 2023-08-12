package AdvanceDSA.QueuesProblems;
/*
Given an integer, A. Find and Return first positive A integers in ascending order containing
only digits 1, 2, and 3.

NOTE: All the A integers will fit in 32-bit integers.



Problem Constraints
1 <= A <= 29500
 */

import java.util.*;

public class P4_NintcontOnlyOneTwoThree {
    public static int[] solve(int A) {
        ArrayList<Integer> arr=new ArrayList<>();
        Queue<Integer> Q=new LinkedList<>();
        if(A==1||A==2||A==3){
            for(int i=1;i<=A;i++){
                arr.add(i);
                Q.add(i);
            }
           return arr.stream().mapToInt(i->i).toArray();
        }
        for(int i=1;i<=3;i++){
            arr.add(i);
            Q.add(i);
        }
        int cnt=3;
        while (cnt<A) {
            int i=Q.remove();
            int nxt=i*10+1;
            arr.add(nxt);
            Q.add(nxt);
            cnt++;
            if(cnt==A) break;
            nxt=i*10+2;
            arr.add(nxt);
            Q.add(nxt);
            cnt++;
            if(cnt==A) break;
            nxt=i*10+3;
            arr.add(nxt);
            Q.add(nxt);
            cnt++;
            if(cnt==A) break;

        }
        return arr.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int [] arr=solve(A);
        System.out.println(Arrays.toString(arr));

    }
}
