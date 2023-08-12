package general.easy;
/*
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.



Problem Constraints
1 <= A <= 1000
 */

import java.util.Arrays;
import java.util.Scanner;

public class P6_SpiralOrderMatrix2 {
    public static int[][] generateMatrix(int A) {
        int [][] res=new int[A][A];
        int cnt=1;
        int rt=0;
        int rb=A-1;
        int cl=0;
        int cr=A-1;
        while (cnt<=A*A){
            //top
            for(int i=cl;i<=cr;i++){
                res[rt][i]=cnt;
                cnt++;
            }
            rt++;
            //right
            for(int i=rt;i<=rb;i++){
                res[i][cr]=cnt;
                cnt++;
            }
            cr--;
            //bottom
            for(int i=cr;i>=cl;i--){
                res[rb][i]=cnt;
                cnt++;
            }
            rb--;
            //left
            for(int i=rb;i>=rt;i--){
                res[i][cl]=cnt;
                cnt++;
            }
            cl++;

        }
        return res;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int [][] res=generateMatrix(A);
        System.out.println(Arrays.deepToString(res));
    }
}
