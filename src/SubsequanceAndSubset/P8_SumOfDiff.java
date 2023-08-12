package SubsequanceAndSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P8_SumOfDiff {
    public static int power(int a,int b){
        if(b==0){
            return 1;
        }
        int pow=0;
        int halfpow=power(a,b/2);
        halfpow=halfpow%1000000007;
        if(b%2==0){
            pow=halfpow*halfpow;
            pow=pow%1000000007;
        }
        else{
            pow=a*halfpow*halfpow;
            pow=pow%1000000007;
        }
        return pow;
    }

    public static int solveM2(int [] A){
        int sumofdiff=0;
        int min=0;
        int max=0;
        int len=A.length;
        Arrays.sort(A);
        for(int i=0;i<len;i++){
            int emt=A[i];
            min+=(emt*(int)(power(2,(len-1-i)))%1000000007);
            max+=(emt*(int)(power(2,i)))%1000000007;

        }
        sumofdiff=max-min;
        return sumofdiff;
    }


    public static int solve(int[] A) {
        int size=A.length;
        int sum=0;

        int binary=1<<size;
        for(int i=1;i<binary;i++){
            ArrayList<Integer> subset=new ArrayList<>();
            int temp=i;
            int index=size-1;
            while(temp>0){
                int set=temp&1;
                temp=temp>>1;
                if(set==1){
                    subset.add(A[index]);
                }
                index--;
            }
            Collections.sort(subset);
            int min=subset.get(0);

            int max=subset.get(subset.size()-1);
            sum+=max-min;
            sum=sum%1000000007;

        }


        return sum;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int sum=solve(A);
        System.out.println(sum);
        sum=solveM2(A);
        System.out.println(sum);

    }
}
