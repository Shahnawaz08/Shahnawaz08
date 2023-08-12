package array.IntermidiateArrays;

import java.util.Scanner;

public class P9_SmallestSubarrayContainingBothMaxAndMinEmt {
    public static int solve(int[] A) {
        int N=A.length;
        //System.out.println(N);
        int minleng=N;
        int min=A[0];
        int max=A[0];
        for(int i=1;i<N;i++){
            if(A[i]>max){
                max=A[i];
            }
            else if (A[i]<min) {
                min=A[i];
            }
        }
        if(max==min){
            return 1;
        }
       // System.out.println(min);
       // System.out.println(max);
        int minidx=-1;
        int maxidx=-1;
        for(int i=N-1;i>=0;i--){
            if(A[i]==min){
                minidx=i;
               // System.out.println(" hi  i am in  first loop");
                if(maxidx != -1){
                 //   System.out.println(" hi  i am in  first of first loop");
                    int len=maxidx-minidx+1;
                    minleng=Math.min(minleng,len);
                }
            } else if (A[i]==max) {
               // System.out.println(" hi  i am in  second loop");
                maxidx=i;
                if(minidx !=-1){
                    int len=minidx-maxidx+1;
                    minleng=Math.min(minleng,len);
                }
            }
        }
        return minleng;
    }
    public static int solve2(int[] A){
        int N=A.length;
        int minemt=Integer.MAX_VALUE;
        int maxemt=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i]>maxemt){
                maxemt=A[i];
            }
            if(A[i]<minemt){
                minemt=A[i];
            }
        }
        //System.out.println(maxemt+" "+minemt);
        int minlength=Integer.MAX_VALUE;
        int maxindex=-1;
        int minindex=-1;
        for(int i=N-1;i>=0;i--){
            if(A[i]==maxemt){
                maxindex=i;
                if(minindex !=-1){
                    int len=minindex-maxindex+1;
                    minlength=Math.min(minlength,len);
                }
            } if (A[i]==minemt) {
                minindex=i;
                if(maxindex!=-1){
                    int len=maxindex-minindex+1;
                    minlength=Math.min(minlength,len);
                }

            }
        }
        return minlength;
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
        len=solve2(A);
        System.out.println("Minimum subarray containing min element and max element is "+len);

    }
}
