package SubsequanceAndSubset;

import java.util.Scanner;

public class P3_AllSubsets {
    public static  int[][] subsets(int[] A) {
        int [][] a=new int[2][1];
        return a;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int [][] subarrays=subsets(arr);
        for(int i=0;i<subarrays.length;i++){
            for (int j=0;j<subarrays[i].length;j++){
                System.out.print(subarrays[i][j]+" ");
            }
            System.out.println();
        }
    }
}
