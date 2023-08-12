package AdvanceDSA.GcdProblems;

import java.util.Scanner;

public class P2_GcdofanArray {
    public static int getGcd(int A, int B) {
        while (A!=0){
            int temp=A;
            A=B%A;
            B=temp;
        }
        return B;
    }
    public static int solve(int[] A) {
        int no=A[0];
        for(int i=1;i<A.length;i++){
            no=getGcd(no,A[i]);
        }
        return no;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int [] A=new int[N];
        for (int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }

        int no=solve(A);
        System.out.println(no);
    }
}
