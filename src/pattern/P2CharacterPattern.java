package pattern;

import java.util.Scanner;

public class P2CharacterPattern {
    public static void stairPattern(int N){
        for(int i=1;i<=N;i++){
            char ch='A';
            for(int j=1;j<=i;j++){
                System.out.print(ch+" ");
                ch +=1;
            }
            ch -=1;
            for(int j=1;j<=i;j++){
                System.out.print(ch+" ");
                ch -=1;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        stairPattern(N);
    }
}
