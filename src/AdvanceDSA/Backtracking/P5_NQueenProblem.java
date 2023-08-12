package AdvanceDSA.Backtracking;
/*
Given an integer A, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.


Problem Constraints
1 <= A <= 10
 */

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P5_NQueenProblem {
    static int idx;
    static ArrayList<ArrayList<String>> allpossiblePos;
    public static boolean isSafe(String [][] board,int i,int j,int N){
        //check the column and row if queen is present or not
        for(int row=0;row<i;row++){
            if(board[row][j].equals("Q")){
                return false;
            }
        }
        //left diagonal
        int x=i-1;
        int y=j-1;
        while (x>=0&&y>=0){
            if(board[x][y].equals("Q")){
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
            if(board[x][y].equals("Q")){
                return false;
            }
            x=x-1;
            y=y+1;
        }
        return true;
    }
    public static void convertToOneD(String [][] board){
        //String [] temp=new String[board.length];
        ArrayList<String> temp=new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            //char [] a=board[i];
            String []stringArray=board[i];
            StringBuffer sb = new StringBuffer();
            for(int j = 0; j < stringArray.length; j++) {
                sb.append(stringArray[j]);
            }
            String s = sb.toString();
            //System.out.println("String vslue of character array "+s);
            temp.add(s);
        }
        //System.out.println(temp);
        allpossiblePos.add(temp);

    }

    public static boolean solveNQueen(String [][] board,int i,int N){
        //base case
        if(i==N){
            convertToOneD(board);
            return true;
        }
        //Recursive course
        for(int j=0;j<N;j++){
            if(isSafe(board,i,j,N)){
                board[i][j]="Q";
                boolean success=solveNQueen(board,i+1,N);
                //if(success) return true;
                //backtracking
                board[i][j]=".";
            }
        }
        //no success in the ith row
        return false;
    }
    public static String[][] solveNQueens(int A) {
        //char [][] s=new char[A][A];
        String [][] s=new String[A][A];

        idx=0;
        if(A==2){
            return null;
        }
        for(int i=0;i<A;i++){
            for(int j=0;j<A;j++){
                s[i][j]=".";
            }
        }
        allpossiblePos=new ArrayList<>();
        boolean success=solveNQueen(s,0,A);
        System.out.println(allpossiblePos);
        String[][] stringArray = allpossiblePos.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);


        return stringArray ;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        String [][] st=solveNQueens(N);
        System.out.println(Arrays.deepToString(st));
    }
}
