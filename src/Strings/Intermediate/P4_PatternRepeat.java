package Strings.Intermediate;
/*
we have to print P1Q2R3P4Q5R5
 */

import java.util.Scanner;

public class P4_PatternRepeat {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            char ch ='P';
            System.out.print((char)(ch+(i-1)%3)+""+i);
        }
    }
}
