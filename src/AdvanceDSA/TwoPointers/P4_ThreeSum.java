package AdvanceDSA.TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class P4_ThreeSum {
    public static int threeSumClosest(int[] A, int B){
        long absdiff=Integer.MAX_VALUE;
        long sum=Integer.MAX_VALUE;
        long tgt=B;
        Arrays.sort(A);
        int N=A.length;
        for(int i=0;i<=N-3;i++){
            int fst=A[i];
            int s=i+1;
            int e=N-1;

            while (s<e){
                int sec=A[s];
                int trd=A[e];
                long temp=fst+sec+trd;
                long diff=0;
                diff=temp>tgt?temp-tgt:tgt-temp;
                long tempabs=diff>0?diff:-diff;
                if(tempabs<absdiff){
                    absdiff=tempabs;
                    sum=temp;

                }
                if(temp==tgt){
                    break;
                } else if (temp>tgt) {
                    e--;

                }
                else {
                    s++;
                }

            }
        }
        return (int) sum;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array followed by the elements");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter the sum ");
        int B=sc.nextInt();
        int sum=threeSumClosest(A,B);
        System.out.println(sum);

    }
}
