package array.TwoDArray;

import java.util.Arrays;

public class P2_TwoDArrayBasic {
    public static void print2DArrayM1(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j< arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void print2DArrayM2(int[][] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    public static void print2DArrayM3(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for (int x:arr[i]) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void print2DArrayM4(int[][] arr){
            for (int[] x:arr) {
                for(int y:x){
                    System.out.print(y+" ");
                }
                System.out.println();
            }
            System.out.println();

    }
    public static void print2DArrayM5(int[][] arr){
        System.out.println("Method 5");
        for (int[] x:arr) {
            System.out.println(Arrays.toString(x));
        }
        System.out.println();

    }
    public static void main(String[] args) {
        //Hard-coded array
        int [][] arr={{1,2,3,4},{4,5,6},{7,8,9}};
        System.out.println(arr);//return address of array
        System.out.println(arr[0]);//address of the 1st array
        System.out.println(arr[0][0]);//value at inder[0][0]
        System.out.println(arr.length);//no.of rows
        System.out.println(arr[0].length);//no of element in 1st col
        print2DArrayM1(arr);
        print2DArrayM2(arr);
        print2DArrayM3(arr);
        print2DArrayM4(arr);
        print2DArrayM5(arr);

    }
}
