package bits_manupulation;

import java.util.Scanner;
//4294967295
public class P1_doubt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long N=sc.nextLong();
        int x=(int)N%2;
        long y=N%2;
        System.out.println(x);
        System.out.println(y);
        long a=Long.MAX_VALUE;
        System.out.println(a);
        int b=Integer.MAX_VALUE;
        System.out.println(b);
        System.out.println("====================================");
        System.out.println('y'&'z');
        //arr=[1,0,1]
        //i=0+1+2
        int n=10;
        System.out.println(n<<2);
        System.out.println(n);
        StringBuilder sb=new StringBuilder("10110");
        sb.reverse();
        System.out.println(sb);
    }
}
