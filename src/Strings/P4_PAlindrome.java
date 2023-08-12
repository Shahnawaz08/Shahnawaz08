package Strings;

import java.util.Scanner;

public class P4_PAlindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int flag=1;
        for (int i=0;i<A.length()/2;i++){
            if(A.charAt(i)!=A.charAt(A.length()-1-i)){
                flag=0;
                break;
            }
        }
        System.out.println(flag);
    }
}
