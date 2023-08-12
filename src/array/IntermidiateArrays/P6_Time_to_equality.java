package array.IntermidiateArrays;

import java.util.Scanner;

public class P6_Time_to_equality {
    public static int solve(int[] A) {
        int max=Integer.MIN_VALUE;
        int time=0;
        for(int i=0;i<A.length;i++){
            if(A[i]>max){
                max=A[i];
            }
        }
        for(int i=0;i<A.length;i++){
            if(A[i]<max){
                time=time+(max-A[i]);
            }
        }
        return  time;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]= sc.nextInt();
        }
        System.out.println("end of for loop");
        int num=solve(A);
        System.out.println("time to make them equal is "+num);
    }
}
