package functions;

import java.util.Scanner;

public class P6_PascalsTriangle {
    public  static int factorial(int n){
        int ans=1;
        for (int i=1;i<=n;i++){
            ans=ans*i;
        }
        return ans;
    }
    public static int bionomialCoeff(int n,int r){
        return  factorial(n)/(factorial(n-r)*factorial(r));
    }
    public static void pascalsTriangle(int n){
        for (int i=0;i<=n;i++){
            for (int j=0;j<=i;j++){
                System.out.print(bionomialCoeff(i,j)+" ");
            }
            System.out.println();
        }
    }
    public static void pascalsTriangleopt(int n){
        for (int i=0;i<=n;i++){
            int res=1;
            for (int j=1;j<=i+1;j++){
                System.out.print(res+" ");
                res=res*(i-j+1)/j;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        pascalsTriangle(N);
        pascalsTriangleopt(N);

    }
}
