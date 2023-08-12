package AdvanceDSA.Arrayproblems;

import java.util.Scanner;

public class P2_MaximumAbsoluteDifference {
    public static int maxArrEffective(int[] A) {
        int N=A.length;
        int maxadd=Integer.MIN_VALUE;
        int minadd=Integer.MAX_VALUE;
        int maxdif=Integer.MIN_VALUE;
        int mindif=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            int addval=A[i]+i+1;
            if(addval>maxadd){
                maxadd=addval;
            }
            if(addval<minadd){
                minadd=addval;
            }
            int subval=A[i]-i-1;
            if(subval>maxdif){
                maxdif=subval;
            }
            if(subval<mindif){
                mindif=subval;
            }


        }
        int diff1=maxadd-minadd;
        int diff2=maxdif-mindif;
        int max=diff1>diff2?diff1:diff2;
        return max;
    }
    public static int maxArr(int[] A) {
        int N=A.length;
        int maxdiff=Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                int diff=Math.abs(A[i]-A[j])+j-i;
                if(diff>maxdiff){
                    maxdiff=diff;
                }

            }
        }
        return maxdiff;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int maxabsdiff=maxArr(arr);
        System.out.println(maxabsdiff);
        maxabsdiff=maxArrEffective(arr);
        System.out.println(maxabsdiff);
    }
}
