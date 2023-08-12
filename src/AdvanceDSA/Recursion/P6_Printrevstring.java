package AdvanceDSA.Recursion;

import java.util.Scanner;

public class P6_Printrevstring {
    public static StringBuilder reverse(StringBuilder S, int s, int e) {
        if (s >= e) {
            return S;
        }
        char temp = S.charAt(s);

        S.setCharAt(s, S.charAt(e));
        S.setCharAt(e, temp);
        return reverse(S, s + 1, e - 1);


    }

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        StringBuilder sb = new StringBuilder(S);
        int s = 0;
        int e = S.length() - 1;
        StringBuilder revS = reverse(sb, s, e);
        System.out.println(revS);

    }
}
