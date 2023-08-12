package bits_manupulation;
/*
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.
 */
//102=1100110
//256=100000000
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P4_findingTwoSingleNum {
    public static int[] solve(int[] A) {
        int[] arr=new int[2];
        int xor=0;
        for(int i=0;i<A.length;i++){
            xor=xor^A[i];
        }
        System.out.println("xor is "+xor);

        int pos=0;
        while((xor&1) !=1){
            pos++;
            xor=xor>>1;
        }
        System.out.println("Pos is "+pos);
        for(int i=0;i<A.length;i++){
            if((A[i]&(1<<pos))>0){
                arr[0]=arr[0]^A[i];
            }
            else{
                arr[1]=arr[1]^A[i];
            }
        }
        return arr;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int[] no=solve(A);
        System.out.println(Arrays.toString(no));
        System.out.println(Arrays.toString(A));

    }
}
