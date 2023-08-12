package array.IntermidiateArrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P5_EquilibiriumIndex {
    public static int solve2(int [] A){
        int count=0;
        long [] EvenPs=new long[A.length];
        long [] OddPs=new long[A.length];
        EvenPs[0]=A[0];
        OddPs[0]=0;
        for(int i=1;i<A.length;i++){
            if(i%2==0){
                EvenPs[i]=EvenPs[i-1]+A[i];
                OddPs[i]=OddPs[i-1];
            }
            else{
                OddPs[i]=OddPs[i-1]+A[i];
                EvenPs[i]=EvenPs[i-1];
            }
        }
        System.out.println(Arrays.toString(EvenPs));
        System.out.println(Arrays.toString(OddPs));
        int N=A.length;
        for(int i=0;i<N;i++){
            int evensum=0;
            int oddsum=0;
            if(i==0){
                evensum=(int)(OddPs[N-1]-OddPs[i]);
                oddsum=(int)(EvenPs[N-1]-EvenPs[i]);
            }
            else {
                evensum=(int)(EvenPs[i-1]+OddPs[N-1]-OddPs[i]);
                oddsum=(int)(OddPs[i-1]+EvenPs[N-1]-EvenPs[i]);
            }
            if(evensum==oddsum){
                count++;
            }
        }

        return count;
    }

    public static int solve(int[] A) {
        int idx=0;
        long[] pa=new long[A.length];
        pa[0]=A[0];
        for(int i=1;i< A.length;i++){
            pa[i]=pa[i-1]+A[i];
        }
        for(int i=0;i<A.length;i++){
            long l=0;
            if(i>0){
                l=pa[i-1];
            }
            long r=pa[A.length-1]-pa[i];
            if(l==r){
                idx++;
            }
        }

        return idx;
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
        System.out.println("Number of Equilibrium index is "+num);
        num=solve2(A);
        System.out.println("Number of Equilibrium index is "+num);
    }
}
