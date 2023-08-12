package AdvanceDSA.Backtracking;

import java.util.Arrays;
/*
Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.'
 You may assume that there will be only one unique solution.
 */
public class P7_sudoku_charArrayInput {
    public static  boolean canPlace(char [][]grid,int i,int j,char number,int N){
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
    public static boolean helperfn(char [][] grid,int i,int j,int N){
        if(i==N){
            System.out.println("Solution exits");
            System.out.println(Arrays.deepToString(grid));
            return true;

        }
        //Recursion case
        //cross the right boundary go to the next row
        if(j==N){
            return helperfn(grid,i+1,0,N);
        }
        //encounter a prefilled cell
        if(grid[i][j]!='.'){
            return helperfn(grid,i,j+1,N);
        }
        //blank cell fill
        for(int number=1;number<=N;number++){
            char charvalofnum=(char)(number+'0');
            if(canPlace(grid,i,j,charvalofnum,N)){
                char a=(char)(number+'0');
                grid[i][j]=a;
                System.out.println("value of grid "+grid[i][j]);
                boolean success=helperfn(grid,i,j+1,N);
                if(success){
                    return true;
                }
            }
        }
        //backtracking
        grid[i][j]='.';
        return false;
    }
    public static void solveSudoku(char[][] A) {
        boolean success=helperfn(A,0,0,A.length);
        System.out.println(" it is successful "+success);
    }
    public static void main(String[] args) {

        String [] grid={ "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79" };
        char [][] chararray=new char[9][9];
        int i=0;
        for(String A:grid){
            char [] temp=A.toCharArray();
            chararray[i]=temp;
            i++;
        }
        //System.out.println(Arrays.deepToString(chararray));
        solveSudoku(chararray);
        System.out.println(Arrays.deepToString(chararray));

    }
}
