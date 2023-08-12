package SubsequanceAndSubset;
/*
Given two strings A and B, find if A is a subsequence of B.
Return "YES" if A is a subsequence of B, else return "NO".
 */

import java.util.Scanner;

public class P1_Subsequance {
    public static String solve(String A, String B) {
        int n=A.length();
        int m=B.length();
        int index=0;
        for(int i=0;i<m;i++){
            if(A.charAt(index)==B.charAt(i)){
                index++;
            }
            if(index==n){
                break;
            }
        }
        System.out.println("HIi");
        if(index==n){
            return "YES";
        }
        return "NO";
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        String isstring=solve(A,B);
        System.out.println(isstring);

    }
}
