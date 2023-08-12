package Recursion_Problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class P9_colRowValidation {
    public static int isValidSudoku(final String[] A) {
        /*
        for(int i=0;i<A.length;i++) {
            System.out.println((A[i]));
        }
       */
        for(int i=0;i<9;i++){
            HashSet<Character> set=new HashSet<>();
            for(int j=0;j<9;j++){
                if(A[i].charAt(j)=='.'){
                    continue;
                }
                if(set.contains(A[i].charAt(j))){
                    return 0;
                }
                set.add(A[i].charAt(j));

            }
        }
        for(int i=0;i<9;i++){
            HashSet<Character> set=new HashSet<>();
            System.out.println("set before "+set);
            for(int j=0;j<9;j++){
                if(A[j].charAt(i)=='.'){
                    continue;
                }
                if(set.contains(A[j].charAt(i))){
                    return 0;
                }
                //System.out.println(A[i].charAt(j));
                set.add(A[j].charAt(i));

            }
            System.out.println("set after "+set);
        }

        return 1;
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
