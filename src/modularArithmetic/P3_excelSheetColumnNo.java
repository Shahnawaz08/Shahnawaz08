package modularArithmetic;
/*
Given a column title as appears in an Excel sheet, return its corresponding column number.
 */

import java.util.Scanner;

public class P3_excelSheetColumnNo {
    public static int titleToNumber(String A) {
        int colno=0;
        int ch=(char)'A';
        int N=A.length();
        int pow=1;
        for(int i=N-1;i>=0;i--){
            char temp=A.charAt(i);
            int no=temp-64;
            colno+=(no%27)*pow;
            pow*=26;

            //System.out.println(no);
        }
        System.out.println(ch);
        return colno;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int coln0=titleToNumber(s);
        System.out.println("column number in excel sheet is "+coln0);
    }
}
