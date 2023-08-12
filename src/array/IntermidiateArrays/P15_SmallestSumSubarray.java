package array.IntermidiateArrays;

import java.util.Scanner;

public class P15_SmallestSumSubarray {
    public static int solve(int[] A, int B) {
        int minsum=Integer.MAX_VALUE;
        int N=A.length;
        int[] ps=new int[N];
        ps[0]=A[0];
        for(int i=1;i<N;i++){
            ps[i]=ps[i-1]+A[i];
        }
        for(int i=0;i<=N-B;i++){
            int sum=0;
            if(i!=0) {
                sum = ps[i + B - 1] - ps[i - 1];
            }
            else{
                sum=ps[i+B-1];
            }
            if(sum<minsum){
                minsum=sum;
            }
        }
        return minsum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]= sc.nextInt();
        }
        System.out.println("Enter size of subarray");
        int B=sc.nextInt();
        int s=solve(A,B);
        System.out.println(s);

    }


}
