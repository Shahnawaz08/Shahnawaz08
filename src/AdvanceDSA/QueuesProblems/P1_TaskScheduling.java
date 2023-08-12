package AdvanceDSA.QueuesProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
A CPU has N tasks to be performed. It is to be noted that the tasks have to be
completed in a specific order to avoid deadlock. In every clock cycle, the CPU can either
perform a task or move it to the back of the queue. You are given the current state of the
scheduler queue in array A and the required order of the tasks in array B.

Determine the minimum number of clock cycles to complete all the tasks.


Problem Constraints
1 <= N <= 1000
1 <= A[i], B[i] <= N
 */
public class P1_TaskScheduling {
    public static int solve(int[] A, int[] B) {
        int noOfClock=0;
        Queue<Integer> Q=new LinkedList<>();
        for (int j : A) {
            Q.add(j);
        }
//       System.out.println(Q);
//        Q.remove();
//        System.out.println(Q);

        for (int j : B) {
            if (Q.peek() == j) {
                noOfClock++;
                Q.remove();
            } else {
                while (Q.peek() !=j) {
                    int emt = Q.remove();
                    Q.add(emt);
                    noOfClock++;
                }
                Q.remove();
                noOfClock++;
            }
        }


        return noOfClock;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int [] B=new int[N];
        System.out.println("Enter sequance of task ");
        for(int i=0;i<N;i++){
            B[i]=sc.nextInt();
        }
        int noOfClock=solve(A,B);
        System.out.println("No of clock cycle require to finish the task is "+noOfClock);
    }
}
