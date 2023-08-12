package Comperators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P2_sortingcomperator {
    public static int comparator(int []a, int [] b){
        return a[0]*a[0]+a[1]*a[1]-b[0]*b[0]-b[1]*b[1];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //int N=sc.nextInt();
        /*
        int [][] A=new int[N][3];
        for(int i=0;i<N;i++){
            for(int j=0;j<3;j++ ){
                A[i][j]=sc.nextInt();
            }
        }

         */
        int [][] A={{1,2},{3,4},{0,2},{1,4}};
        System.out.println(Arrays.deepToString(A));
        Arrays.sort(A,(int [] a,int [] b)-> (a[0]*a[0]+a[1]*a[1]-b[0]*b[0]-b[1]*b[1]));
        //Arrays.sort(A,comparator(int [] a,int[] b));
        //sort acc to x cordinate

        //Arrays.sort(A, Comparator.comparingInt((int [] obj)->(obj[0])));
      //Arrays.sort(A,Comparator.comparing());
        //sort according to y coordinate
        //Arrays.sort(A, Comparator.comparingInt((int [] obj)->(obj[1])));
        //sort according to distance from 0,0
       // Arrays.sort(A, Comparator.comparingInt((int [] obj)->(obj[0]*obj[0]+obj[1]*obj[1])));


        System.out.println(Arrays.deepToString(A));

    }
}
