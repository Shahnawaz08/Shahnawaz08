package AdvanceDSA.Backtracking;

import java.util.Arrays;
import java.util.Scanner;
//Print a valid configuration
public class P4_NQueenProblem {
    public static void printBoard(int [][] board){
        int N=board.length;
        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }
        //System.out.println(Arrays.deepToString(board));
    }
    public static boolean isSafe(int [][] board,int i,int j,int N){
        //check the column and row if queen is present or not
        for(int row=0;row<i;row++){
            if(board[row][j]==1){
                return false;
            }
        }
        //left diagonal
        int x=i-1;
        int y=j-1;
        while (x>=0&&y>=0){
            if(board[x][y]==1){
                return false;
            }
            x=x-1;
            y=y-1;
        }
        //Right Diagonal
        x=i-1;
        y=j+1;
        while (x>=0&&y<N)
        {
           if(board[x][y]==1){
               return false;
           }
           x=x-1;
           y=y+1;
        }
        return true;
    }
    public static boolean solveNQueen(int [][] board,int i,int N){
        //base case
        if(i==N){
            printBoard(board);
            return true;
        }
        //Recursive course
        for(int j=0;j<N;j++){
            if(isSafe(board,i,j,N)){
                board[i][j]=1;
                boolean success=solveNQueen(board,i+1,N);
                if(success) return true;
                //backtracking
                board[i][j]=0;
            }
        }
        //no success in the ith row
        return false;
    }

    ///to print all the possible board
    public static boolean solveNQueenAllPos(int [][] board,int i,int N){
        //base case
        if(i==N){
            printBoard(board);
            return true;
        }
        //Recursive course
        for(int j=0;j<N;j++){
            if(isSafe(board,i,j,N)){
                board[i][j]=1;
                boolean success=solveNQueenAllPos(board,i+1,N);
                //if(success) return true;
                //backtracking
                board[i][j]=0;
            }
        }
        //no success in the ith row
        return false;
    }
    //number of possible arrangement
    public static int solveNQueenNoOfArrange(int [][] board,int i,int N){
        //base case
        if(i==N){
           // printBoard(board);
            return 1;
        }
        int cnt=0;
        //Recursive course
        for(int j=0;j<N;j++){
            if(isSafe(board,i,j,N)){
                board[i][j]=1;
                int  success=solveNQueenNoOfArrange(board,i+1,N);
                cnt=cnt+success;
                //if(success) return true;
                //backtracking
                board[i][j]=0;
            }
        }
        //no success in the ith row
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [][] board=new int[N][N];
        boolean isQueenPlaced=solveNQueen(board,0,N);
        System.out.println("----------------------------------------------");
        boolean isQueenPlacedAllPos=solveNQueenAllPos(board,0,N);
        int noOfarrangement=solveNQueenNoOfArrange(board,0,N);
        System.out.println("Total no of arrangement possible is "+noOfarrangement);

    }
}
