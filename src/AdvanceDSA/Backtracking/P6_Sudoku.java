package AdvanceDSA.Backtracking;

import java.util.Arrays;

public class P6_Sudoku {
    public static  boolean canPlace(int [][]grid,int i,int j,int number,int N){
        //Checking for same element in rowas and column
        //if same element is present then we should not place this
        //number in this place
        for(int x=0;x<N;x++){
            if(grid[x][j]==number||grid[i][x]==number){
                return false;
            }
        }
        //check for same in subgrid
        int ax=(i/3)*3;
        int ay=(j/3)*3;
        for(int x=ax;x<ax+3;x++){
            for(int y=ay;y<ay+3;y++){
                if(grid[x][y]==number){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean helperfn(int [][] grid,int i,int j,int N){
        if(i==N){
            printBoard(grid);
            System.out.println("hii");
            return true;

        }
        //Recursion case
        //cross the right boundary go to the next row
        if(j==N){
            return helperfn(grid,i+1,0,N);
        }
        //encounter a prefilled cell
        if(grid[i][j]!=0){
            return helperfn(grid,i,j+1,N);
        }
        //blank cell fill
        for(int number=1;number<=N;number++){
            if(canPlace(grid,i,j,number,N)){
                System.out.println(i+" "+j+" "+number);
                grid[i][j]=number;
                boolean success=helperfn(grid,i,j+1,N);
                if(success){
                    return true;
                }
            }
        }
        //backtracking
        grid[i][j]=0;
        return false;
    }
    public static void printBoard(int [][] board){
        int N=board.length;
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
        //System.out.println(Arrays.deepToString(board));
    }
    public static void solveSudoku(int[][] A) {
        boolean success=helperfn(A,0,0,9);
        if(success){
            System.out.println("Solution exits");
        }
    }
    public static void main(String[] args) {

        /*int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

         */

        int grid [][]={{5,3,0,0,7,0,0,0,0},
            {6,0,0,1,9,5,0,0,0},
            {0,9,8,0,0,0,0,6,0},
            {8,0,0,0,6,0,0,0,3},
            {4,0,0,8,0,3,0,0,1},
            {7,0,0,0,2,0,0,0,6},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,8,0,0,7,9}};


        solveSudoku(grid);
        System.out.println('7'-'0');
        System.out.println(Arrays.deepToString(grid));
    }

}
