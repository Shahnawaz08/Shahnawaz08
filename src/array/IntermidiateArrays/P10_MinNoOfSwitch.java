package array.IntermidiateArrays;
/*
A wire connects N light bulbs.
Each bulb has a switch associated with it; however, due to faulty wiring,
a switch also changes the state of all the bulbs to the right of the current bulb.
Given an initial state of all bulbs, find the minimum number of switches you have to
press to turn on all the bulbs. You can press the same switch multiple times.

Note: 0 represents the bulb is off and 1 represents the bulb is on.
 */

import java.util.Scanner;

public class P10_MinNoOfSwitch {
    public static  int solve(int[] A){
        int nSwitch=0;
        int nzero=0;
        for(int i=0;i<A.length-1;i++){
            if(A[i]==1&&A[i+1]==0){
                nSwitch++;
            }
            else if(A[i]==0&&A[i+1]==1){
                nSwitch+=2;
            }
            else if (A[i]==0){
                nzero++;
            }
        }
        if(A[A.length-1]==0){
            nzero++;
        }
        if(nzero==A.length){
            return 1;
        }
        return nSwitch;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]= sc.nextInt();
        }
        int len=solve(A);
        System.out.println("Minimum subarray containing min element and max element is "+len);
    }
}
