package general.easy;

import java.util.Arrays;
import java.util.Scanner;

public class P20_SpiralOrderMatrix2 {
    public static int[][] generateMatrix(int A) {
        int [][] mat=new int[A][A];
        int rl=0;
        int rr=A-1;
        int ct=0;
        int cb=A-1;
        int val=1;
        while(val<=(A*A)){
            for(int i=rl;i<=rr;i++){
                mat[ct][i]=val;
                val++;
            }
            if(val>A*A) break;
            ct++;
            for(int i=ct;i<=cb;i++){
                mat[i][rr]=val;
                val++;
            }
            if(val>A*A) break;
            rr--;
            for(int i=rr;i>=rl;i--){
                mat[cb][i]=val;
                val++;
            }
            if(val>A*A) break;
            cb--;
            for(int i=cb;i>=ct;i--){
                mat[i][rl]=val;
                val++;
            }
            if(val>A*A) break;
            rl++;
        }
        return mat;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int [][] spiralMatr=generateMatrix(A);
        System.out.println(Arrays.deepToString(spiralMatr));
    }
}
