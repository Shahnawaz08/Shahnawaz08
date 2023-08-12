package general.easy;

import java.util.Scanner;

public class P4_SubsetXor {
    public static int solve(int[] A) {
        int res=0;
        for(int i=0;i<A.length;i++){
//            int temp=0;
            for(int j=0;j<i;j++){
                int temp=0;
                for(int k=j;k<=i;k++){
                    temp=temp^A[k];
                }
                res=temp^res;
            }
//            res=temp^res;
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int ans=solve(A);
        int chA=(int)'A';
        int cha=(int)'a';
        System.out.println(chA);
        System.out.println(cha);
    }
}
