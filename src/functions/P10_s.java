package functions;

import java.util.Scanner;

public class P10_s {
    public static int gcd(int a,int b){
        while (a>0){
            if(b>a){
                b=b-a;
            }
            else{
                a=a-b;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int x=gcd(a,b);
        System.out.println(x);
    }
}
