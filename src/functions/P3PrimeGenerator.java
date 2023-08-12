package functions;

import java.util.Scanner;

public class P3PrimeGenerator {
    public static boolean checkPrime(int n) {
        for(int i=2;i<n;i++){
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
    public static void printPrime(int A,int B){
        if(A>B){
            int temp=A;
            A=B;
            B=temp;
        }
        for(int i=A;i<=B;i++){
            if(checkPrime(i)==true){
                System.out.print(i+" ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        printPrime(A,B);
    }
}
