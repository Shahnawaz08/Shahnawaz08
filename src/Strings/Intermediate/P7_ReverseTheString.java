package Strings.Intermediate;

import java.util.Scanner;
/*
You are given a string A of size N.
Return the string A after reversing the string word by word.
NOTE:
A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.

 */

public class P7_ReverseTheString {
    public static void rev(StringBuilder A ,int l,int r) {
        while (l<r){
            char temp=A.charAt(l);
            A.setCharAt(l,A.charAt(r));
            A.setCharAt(r,temp);
            l++;
            r--;
        }
    }
    public static String revString(String A ) {
        StringBuilder sb=new StringBuilder();
        int N=A.length();
        System.out.println(" initial N is "+N);
        int l=0;
        int r=0;
        //sb.append(A);
        for(int i=0;i<N;i++){
            if(A.charAt(i)==' '){
                while (i<N-1 && A.charAt(i) == ' ' && A.charAt(i+1)==' ') {
                    i++;
                }
            }
            if(i==N-1 &&A.charAt(i)==' '){
                continue;
            }
            sb.append(A.charAt(i));
        }
        N=sb.length();
        System.out.println(N);

        /*
        rev(sb,l,N-1);
        for(int i=0;i<N;i++){
            if(sb.charAt(i)==' ' || i==N-1){
                if(i==N-1){
                    i=N;
                }
                rev(sb,l,i-1);
                l=i+1;
            }
        }

         */
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.nextLine();
        //System.out.println(S);
        String S_rev=revString(S);
        System.out.println(S_rev);

    }
}
