package array.TwoDArray;

import java.util.Arrays;
import java.util.Scanner;

public class P3_CreatingA2DArray {
    public static  int[][] createuserInput2DArray(){
        Scanner sc=new Scanner(System.in);
        int rows =sc.nextInt();
        int cols =sc.nextInt();
        int[][] arr=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr=createuserInput2DArray();
        for(int[] obj:arr){
            System.out.println(Arrays.toString(obj));
        }
    }
}
