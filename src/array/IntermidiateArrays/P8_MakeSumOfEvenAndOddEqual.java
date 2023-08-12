package array.IntermidiateArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P8_MakeSumOfEvenAndOddEqual {
    public static int solve(int[] A) {
        int N=A.length;
        int cnt=0;
        long[] ps_even=new long[N];
        long[] ps_odd=new long[N];
        ps_even[0]=A[0];
        ps_odd[0]=0;
        for(int i=1;i<N;i++){
            if(i%2==0){
                ps_even[i]=ps_even[i-1]+A[i];
                ps_odd[i]=ps_odd[i-1];
            }
            else{
                ps_odd[i]=ps_odd[i-1]+A[i];
                ps_even[i]=ps_even[i-1];
            }
        }
        System.out.println(Arrays.toString(ps_even));
        System.out.println(Arrays.toString(ps_odd));
        for(int i=0;i<N;i++){
            long even=0;
            long odd=0;
            if(i==0){
                odd=ps_even[N-1]-A[0];
                even=ps_odd[N-1];
            }
            else if(i%2==0){
                odd=ps_odd[i-1]+ ps_even[N-1]-A[i];
                even=ps_even[i-1]+ps_odd[N-1]-A[i];
            }
            else{
                even=ps_even[i-1]+ps_odd[N-1]-A[i];
                odd=ps_odd[i-1]+ ps_even[N-1]-ps_even[i-1];
            }
            if(even==odd){
                cnt++;
            }
        }
        return cnt;
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
