package array.IntermidiateArrays;

import java.util.Scanner;

public class P16_LargestSumSubarraySum {
    public static int solve(int[] C,int B){
        int A=C.length;
        int maxval=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i=0;i<A;i++){
            if(C[i]<min){
                min=C[i];
            }
        }
        if(min>B){
            return maxval;
        }
        int[] ps=new int[A];
        ps[0]=C[0];
        for(int i=1;i<A;i++){
            ps[i]=ps[i-1]+C[i];
        }
        int sum=0;
        for(int i=0;i<A;i++){
            for(int j=i;j<A;j++){
                if(i==0) {
                    sum = ps[j];
                }
                else {
                    sum=ps[j]-ps[i-1];
                }
                if(sum>B) {
                    break;
                }
                if(sum>maxval){
                    maxval=sum;
                }
            }
        }



        return maxval;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N = sc.nextInt();
        int[] C = new int[N];
        for (int i = 0; i < N; i++) {
            C[i] = sc.nextInt();
        }
        System.out.println("Enter size of subarray");
        int B = sc.nextInt();
        int s = solve(C, B);
        System.out.println(s);
    }
}
