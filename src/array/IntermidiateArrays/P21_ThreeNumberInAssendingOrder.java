package array.IntermidiateArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P21_ThreeNumberInAssendingOrder {
    public static void findingThreeAssendigelmt(int[] A){
        int N=A.length;
        int p;
        int q;
        int r;

        for(int i=0;i<=N-3;i++){
            p=i;
            q=-1;
            r=-1;
            //System.out.println(p);
            for(int j=i+1;j<N;j++){
                if(A[j]>A[p]){
                    q=j;
                    for(int k=q+1;k<N;k++){
                        if(A[k]>A[q]){
                            //System.out.println("value of j "+j+" value of q "+q);
                            r=k;
                            System.out.println(p+" "+q+" "+r);
                        }
                    }
                }
            }
           // System.out.println(p+" "+q+" "+r);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        findingThreeAssendigelmt(A);

    }
}
