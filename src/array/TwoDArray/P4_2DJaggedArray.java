package array.TwoDArray;

import java.util.Arrays;
import java.util.Scanner;

public class P4_2DJaggedArray {
    public static  int[][] createuserDefJaggedInput2DArray(){
        Scanner sc=new Scanner(System.in);
        int rows =sc.nextInt();
        int[][] arr=new int[20][20];
        for(int i=0;i<rows;i++){
            int cols =sc.nextInt();
            for(int j=0;j<cols;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        return arr;
    }
    public static  int[][] jaggedInput2DArray(){
        Scanner sc=new Scanner(System.in);
        int rows =sc.nextInt();
        int[][] arr=new int[rows][];
        for(int i=0;i<rows;i++){
            int cols =sc.nextInt();
            arr[i]=new int[cols];
            for(int j=0;j<cols;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr=jaggedInput2DArray();
        for(int[] obj:arr){
            System.out.println(Arrays.toString(obj));
        }
    }
}
