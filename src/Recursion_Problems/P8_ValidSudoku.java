package Recursion_Problems;

import java.util.Scanner;
/*
123456789
abcdefghi
ABCDEFGHI
987654321
123456789
abcdefghi
ABCDEFGHI
987654321
abcdefghi
 */

public class P8_ValidSudoku {
    public static int isValidSudoku(final String[] A) {
        int i = 0;
        while(i<9){
        int n1 = i + 3;
        int j = 0;
        while (j < 9) {
            int n2 = j + 3;
            for (; i < n1; i++) {
                for (; j < n2; j++) {
                    System.out.print(A[i].charAt(j));
                }
                j = j - 3;
                System.out.print(" ");
            }
            j = j + 3;
            i = i - 3;
        }
            System.out.println();
        /*
            System.out.println();
            System.out.println("value of i "+i);
            System.out.println("value of j "+j);
            System.out.println("value of n1 "+n1);


         */
            //System.out.println("value of i "+i);


        i = i + 3;

    }
        System.out.println();


        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String [] st=new String[9];
        for(int i=0;i<9;i++){
            st[i]=sc.next();
        }
        int valid=isValidSudoku(st);
        System.out.println(valid);
    }
}
