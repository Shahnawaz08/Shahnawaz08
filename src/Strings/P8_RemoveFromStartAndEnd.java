/*You are given a character string A. You to trim(remove) both leading and
trailing asterisk characters('*') in the string and return the resultant string.*/
package Strings;

import java.util.Scanner;

public class P8_RemoveFromStartAndEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        StringBuilder B = new StringBuilder();
        int startinder = 0;
        int endInder = A.length();
        System.out.println(A.length());
        int i=0;
            while ( i<A.length()&&A.charAt(i) == '*') {
                startinder++;
                i++;
            }
        System.out.println(A.length());
             i=A.length()-1;
                while (i>=0 && A.charAt(i) == '*'){
                    endInder--;
                    i--;
                }
        System.out.println(A.length());

            for ( i = startinder; i < endInder; i++) {
                B = B.append(A.charAt(i));
            }
            System.out.println(B);

    }
}
