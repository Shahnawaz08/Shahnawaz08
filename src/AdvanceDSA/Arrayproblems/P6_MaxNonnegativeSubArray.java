package AdvanceDSA.Arrayproblems;

import java.util.Arrays;
import java.util.Scanner;

public class P6_MaxNonnegativeSubArray {
    public static int[] maxset(int[] A) {
        int start=-1;
        int end=-1;
        long ans=Integer.MIN_VALUE;
        int maxlen=0;
        int N=A.length;
        for(int i=0;i<N;i++){
            if(A[i]>=0){
                long sum=0;
                int s=i;
                while (i<N && A[i]>=0){
                    sum=sum+A[i];
                    i++;
                }
                 int e=i-1;
                int len=e-s+1;
                if(sum==ans && len>maxlen){
                    start=s;
                    end=e;
                    maxlen=len;
                }
                if(sum>ans){
                    ans=sum;
                    maxlen=len;
                    start=s;
                    end=e;
                }
            }
        }
        int [] arr=new int[maxlen];
        System.out.println(maxlen);
        for(int i=0;i<maxlen;i++){
            arr[i]=A[start+i];
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int [] maxarray=maxset(arr);
        System.out.println(Arrays.toString(maxarray));
    }

}
