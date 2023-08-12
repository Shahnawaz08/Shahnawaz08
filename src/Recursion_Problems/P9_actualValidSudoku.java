package Recursion_Problems;

import java.util.HashSet;
import java.util.Scanner;

public class P9_actualValidSudoku {
    public static int isValidSudoku(final String[] A) {
        int valid = 0;
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
            for(int j=0;j<9;j++){
                if(A[j].charAt(i)=='.'){
                    continue;
                }
                if(set.contains(A[j].charAt(i))){

                    return 0;
                }
                set.add(A[j].charAt(i));

            }
        }

        int i = 0;
        while(i<9){

            int n1 = i + 3;
            int j = 0;
            while (j < 9) {
                HashSet<Character> set=new HashSet<>();
                int n2 = j + 3;
                for (; i < n1; i++) {
                    for (; j < n2; j++) {
                        if(A[i].charAt(j)=='.'){
                            continue;
                        }
                        if(set.contains(A[i].charAt(j))){

                            return 0;
                        }
                        set.add(A[i].charAt(j));
                    }

                    j = j - 3;
                }

                j = j + 3;
                i = i - 3;

            }


            i = i + 3;

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
