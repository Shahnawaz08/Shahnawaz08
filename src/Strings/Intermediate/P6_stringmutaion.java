package Strings.Intermediate;

import java.util.Arrays;
import java.util.Scanner;

public class P6_stringmutaion {
    public static String solve1(String A) {
        StringBuilder sb=new StringBuilder();
        int N = A.length();
        int l = 0;
        int r = N - 1;
        for(int i=N-1;i>=0;i--){
            sb.append(A.charAt(i));
        }
        return sb.toString();
    }
    public static String solve(String A) {
        char [] ch=A.toCharArray();
        int N = A.length();
        int l = 0;
        int r = N - 1;
        while (l < r) {
            char temp = ch[l];
            ch[l]=ch[r];
            ch[r]=temp;
            l++;
            r--;
        }

        String ans="";
        for(int i=0;i<N;i++){
            ans+=ch[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        String sAfter=solve1(S);
        System.out.println(sAfter);

    }
}
