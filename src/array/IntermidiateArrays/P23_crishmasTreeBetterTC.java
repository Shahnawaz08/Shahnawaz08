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

public class P23_crishmasTreeBetterTC {
    public static int solve(int[] A, int[] B) {
        int minprice=Integer.MAX_VALUE;
        int initialminprice=Integer.MAX_VALUE;
        int N=A.length;
        int p,q,r;
        int loopmin;
        for(int i=1;i<=N-2;i++){
            int Aq=A[i];
            int Bq=B[i];
            int Bp=Integer.MAX_VALUE;
            int Ap=-1;
            int Ar;
            int Br=Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                if(Bp>B[j]&& A[j]<Aq){
                    Ap=A[j];
                    Bp=B[j];
                }
            }
            if(Ap==-1){
                continue;
            }

            for(int k=i+1;k<N;k++){
                if(Br>B[k]&& A[k]>Aq){
                    Ar=A[k];
                    Br=B[k];
                    loopmin=Bp+Bq+Br;
                    System.out.println(Ap+" "+Aq+" "+Ar);
                    System.out.println(Bp+" "+Bq+" "+Br);
                    if(minprice>loopmin){
                        minprice=loopmin;
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
