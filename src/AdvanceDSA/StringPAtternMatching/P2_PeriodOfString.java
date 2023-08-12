package AdvanceDSA.StringPAtternMatching;

import java.util.Arrays;
import java.util.Scanner;

public class P2_PeriodOfString {
    public static int findPeriod(String A) {
        int length = A.length();

        // Initially consider there is no period for given
        // String
        int period = -1;

        /*set two pointers one(i) at
        index 0 and other(j) at index 1. increment j till
        first character is obtained  in the string*/
        int i = 0;
        for (int j = 1; j < length; j++) {
            int currChar = A.charAt(j);
            int comparator = A.charAt(i);

            /*If current character matches with first
             *character
             *update period as the difference of j and i*/
            if (currChar == comparator) {
                period = (j - i);
                i++;
            }

            /* if any mismatch occurs in between set i to
             * zero also check if current character again
             * matches
             * with starting character. If matches, update
             * period*/
            else {
                if (currChar == A.charAt(0)) {
                    i = 1;
                    period = j;
                } else {
                    i = 0;
                    period = -1;
                }
            }
        }
        return period;
    }
    public static int solve(String S){
        int T=findPeriod(S);
        return T;


    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int noOfshifts=solve(A);
        System.out.println("Period of string is  "+noOfshifts);
    }
}
