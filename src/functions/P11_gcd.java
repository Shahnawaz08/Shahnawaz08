package functions;

import java.util.Scanner;

public class P11_gcd {
    public static int gcd(int[] A){
        int minemt=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            if(A[i]<minemt){
                minemt=A[i];
            }
        }
       // System.out.println(minemt);
        int flag=0;
        for(int i=minemt;i>0;i--){
            flag=0;
            for(int j=0;j<A.length;j++){
                if(A[j]%i !=0){
                    break;
                }
                flag++;
            }
            if(flag==A.length){
                return i;
            }
        }
        return 1;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N= sc.nextInt();
        int[] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int g=gcd(A);
        System.out.println(g);
    }
}
