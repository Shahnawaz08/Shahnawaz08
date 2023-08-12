package Strings;

import java.util.Scanner;

public class P9_countVowlsAndConsunant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        int []count=new int[2];
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='a' ||A.charAt(i)=='e'||A.charAt(i)=='i'||
            A.charAt(i)=='o'||A.charAt(i)=='u'){
                count[0]++;
            }
            else{
                count[1]++;
            }
        }
    }
}
