package SubsequanceAndSubset;

import java.util.Scanner;
/*
Little Ponny has been given a string A, and he wants to find out the lexicographically
minimum subsequence from it of size >= 2. Can you help him?
A string a is lexicographically smaller than string b, if the first different letter in a and b is smaller in a.

For example, "abc" is lexicographically smaller than "acc" because the first different letter is 'b' and 'c'
which is smaller in "abc".
 */

public class P6_LittlePonnyand2_Subsequence {
    public static String solve(String A) {
        String S="";
        char ch='z';
        int i=0;
        int index=-1;
        for(i=A.length()-2;i>0;i--){
            if(A.charAt(i)<=ch){
                ch=A.charAt(i);
                index=i;
            }
        }
        S+=ch;
        ch='z';
        //System.out.println(index);
        for(int j=index+1;j<A.length();j++){
            if(A.charAt(j)<ch){
                ch=A.charAt(j);
                //System.out.println(ch);
            }
        }
        S+=ch;


        return S;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();

        String isstring=solve(A);
        System.out.println(isstring);

    }
}
