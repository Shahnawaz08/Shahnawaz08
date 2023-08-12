package Strings;

import java.util.Scanner;

public class P10_stringComp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int flag=-1;
        if(A.compareTo(B)==0){
            flag=0;
        }
        if(A.compareTo(B)>0){
            flag=1;
        }
        System.out.println(flag);
    }
}
