package array.IntermidiateArrays;

import java.util.Scanner;

public class P27_MagicNo {
    public static int solve(int A) {
        int pow=5;
        int magno=0;
        while (A>0){
            int rem=A%2;
            magno+=rem*pow;
            pow*=5;
            A=A/2;

        }
        return magno;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int magNo=solve(N);
        System.out.println("Magic number at inder "+N+" is "+magNo);
    }
}
