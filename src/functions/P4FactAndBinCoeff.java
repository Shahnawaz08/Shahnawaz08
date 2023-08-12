package functions;

import java.util.Scanner;

public class P4FactAndBinCoeff {
    public  static int factorial(int n){
        int ans=1;
        for (int i=1;i<=n;i++){
            ans=ans*i;
        }
        return ans;
    }
    public static int bionomialCoeff(int n,int r){
        return factorial(n)/(factorial(n-r)*factorial(r));
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(factorial(n));
        System.out.println(bionomialCoeff(n,2));
    }

}
