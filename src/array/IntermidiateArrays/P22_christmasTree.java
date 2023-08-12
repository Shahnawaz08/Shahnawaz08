package array.IntermidiateArrays;
/*
You are given an array A consisting of heights of Christmas trees and an array B
of the same size consisting of the cost of each of the trees (Bi is the cost of tree Ai,
where 1 ≤ i ≤ size(A)),and you are supposed to choose 3 trees (let's say, indices p, q, and r),
such that Ap < Aq < Ar, where p < q < r.The cost of these trees is Bp + Bq + Br.
You are to choose 3 trees such that their total cost is minimum. Return that cost.
If it is not possible to choose 3 such trees return -1.
 */

import java.util.Scanner;

public class P22_christmasTree {
    public static int solve(int[] A, int[] B) {
        int minprice=Integer.MAX_VALUE;
        int initialminprice=Integer.MAX_VALUE;
        int N=A.length;
        int p,q,r;
        for(int i=0;i<=N-3;i++){
            p=i;
            q=-1;
            r=-1;
            for(int j=i+1;j<N;j++){
                if(A[j]>A[p]){
                    q=j;
                    for(int k=q+1;k<N;k++){
                        if(A[k]>A[q]){
                            r=k;
                            System.out.println(p+" "+q+" "+r);
                            int currentsum=B[p]+B[q]+B[r];
                            if(minprice>currentsum){
                                minprice=currentsum;
                            }
                        }
                    }
                }
            }
        }
        if(minprice==initialminprice){
            return -1;
        }
        return minprice;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        int leastPricePossible=solve(A,B);
        System.out.println("minimum money required is "+leastPricePossible);

    }
}
