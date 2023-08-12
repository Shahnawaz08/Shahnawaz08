package Strings;

import java.util.Scanner;

public class P5_RemoveLastChar {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B="";
        for (int i=0;i<A.length()-1;i++){
            B=B+A.charAt(i);
        }
        System.out.println(B);
    }
}
