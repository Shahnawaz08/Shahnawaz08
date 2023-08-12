package Strings.Intermediate;

import java.util.Scanner;
/*
Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:

Concatenate the string with itself.
Delete all the uppercase letters.
Replace each vowel with '#'.
You are given a string A of size N consisting of lowercase and uppercase alphabets.
Return the resultant string after applying the above operations.

NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.
 */

public class P9_Stringoperation {
    public static String solve(String A) {
        StringBuilder sb=new StringBuilder();
        sb.append(A);
        sb.append(A);
        System.out.println(sb);
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)>='A' &&sb.charAt(i)<='Z'){
                sb.deleteCharAt(i);
                i--;
            }
        }
        System.out.println();
        System.out.println(sb);
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='a'||sb.charAt(i)=='e'||sb.charAt(i)=='i'||sb.charAt(i)=='0'||sb.charAt(i)=='u'){
                sb.replace(i,i+1,"#");
            }
        }
//        System.out.println(sb);
        return sb.toString();

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.nextLine();
        //System.out.println(S);
        String S_pland=solve(S);
        System.out.println(S_pland);

    }

}
