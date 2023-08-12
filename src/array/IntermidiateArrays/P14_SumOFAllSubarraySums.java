package array.IntermidiateArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P14_SumOFAllSubarraySums {
    public static long subarraySum(int[] A) {
        int N=A.length;
        int[] ps=new int[N];
        ps[0]=A[0];
        for(int i=1;i<N;i++){
            ps[i]=ps[i-1]+A[i];
        }
        //System.out.println(Arrays.toString(ps));
        long sum=0;
        for(int i=0;i<N;i++){
            for(int j=i;j<N;j++){
                if(i==0){
                    sum=sum+ps[j];
                }
                else {
                    sum += ps[j] - ps[i - 1];
                }
            }
        }
        return sum;
    }

    public static long subarraySumM2(int[] A) {
        int N=A.length;
        int[] ps=new int[N];
        ps[0]=A[0];
        for(int i=1;i<N;i++){
            ps[i]=ps[i-1]+A[i];
        }
        //System.out.println(Arrays.toString(ps));
        long sum=0;
        for(int i=0;i<N;i++){
            for(int j=N-1;j>=i;j--){
                if(i==0){
                    sum=sum+ps[j];
                }
                else{
                    sum=sum+ps[j]-ps[i-1];
                }

            }
        }
        return sum;
    }
    public static long subarraySumM3(int[] A) {
        int N=A.length;
        int[] ps=new int[N];
        ps[0]=A[0];
        for(int i=1;i<N;i++){
            ps[i]=ps[i-1]+A[i];
        }
        //System.out.println(Arrays.toString(ps));
        long sum=0;
        for(int i=0;i<N;i++){
            int j=N-i-1;
            if(j<i){
                break;
            }
            if(i==0){
                sum=sum+ps[N-1]*(j-i+1);
            }
            else{
                sum=sum+(ps[j]-ps[i-1])*(j-i+1);
            }

        }
        return sum;
    }
    public static long subarraySumM4(int[] A) {
        int N=A.length;

        //System.out.println(Arrays.toString(ps));
        long sum=0;
        for(int i=0;i<N;i++){
            sum+=A[i]*(i+1)*(N-i);

        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]= sc.nextInt();
        }
        long s=subarraySum(A);
        System.out.println(s);
        s=subarraySumM2(A);
        System.out.println(s);

        s=subarraySumM3(A);
        System.out.println(s);

        s=subarraySumM4(A);
        System.out.println(s);


    }
}
