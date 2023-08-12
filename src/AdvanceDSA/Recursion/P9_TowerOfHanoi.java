package AdvanceDSA.Recursion;
/*
In the classic problem of the Towers of Hanoi, you have 3 towers numbered from 1 to 3 (left to right) and A disks numbered from 1 to A (top to bottom) of different sizes which can slide onto any tower.
The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on top of an even larger one).
You have the following constraints:
Only one disk can be moved at a time.
A disk is slid off the top of one tower onto another tower.
A disk cannot be placed on top of a smaller disk.
You have to find the solution to the Tower of Hanoi problem.
You have to return a 2D array of dimensions M x 3, where M is the minimum number of moves needed to solve the problem.
In each row, there should be 3 integers (disk, start, end), where:

disk - number of disk being moved
start - number of the tower from which the disk is being moved
stop - number of the tower to which the disk is being moved
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P9_TowerOfHanoi {
    static  int [][] arr;
    static int index=0;
    public static void helper(int n,int src,int helper,int dest){
        //Base case
        if(n==0){
            return;
        }
        helper(n-1,src,dest,helper);
        arr[index][0]=n;
        arr[index][1]=src;
        arr[index][2]=dest;

        index++;
        //System.out.println(index);
        helper(n-1,helper,src,dest);


    }
    public static int[][] towerOfHanoi(int A) {
        index=0;//to clear all test cases
        arr=new int[(1<<A)-1][3];

        helper(A,1,2,3);
        return arr;
    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int [][]pattern=towerOfHanoi(A);
        System.out.println(Arrays.deepToString(pattern));
    }
}
