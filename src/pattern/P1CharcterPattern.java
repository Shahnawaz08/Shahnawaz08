package pattern;

import java.util.Scanner;

public class P1CharcterPattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            char ch='A';
            for(int j=1;j<=i;j++){
                System.out.print(ch+" ");
                ch +=1;
            }
            System.out.println();
        }
        for(int i=1;i<=n;i++){
            char ch='A';
            for(int j=0;j<i;j++){
                System.out.print((char)(ch+j)+" ");

            }
            System.out.println();
        }
    }
}
