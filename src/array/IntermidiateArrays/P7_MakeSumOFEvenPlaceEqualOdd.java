package array.IntermidiateArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P7_MakeSumOFEvenPlaceEqualOdd {
    public static int solve(int[] A) {
        int N=A.length;
        int cnt=0;
        long [] ps=new long[N-1];
        for(int i=0;i<N;i++){
            int x=0;
            for(int j=0;j<N;j++){

                if(i==j){
                    continue;
                }
                ps[x]=A[j];
                x++;
            }
            System.out.println(Arrays.toString(ps));
            int osum=0;
            int esum=0;
            for(int k=0;k<ps.length;k++){
                if(k%2==0){
                    esum+=ps[k];
                }
                else{
                    osum+=ps[k];
                }
            }
            if(esum==osum){
                cnt++;
            }

        }
       return cnt;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]= sc.nextInt();
        }
        System.out.println("end of for loop");
        int num=solve(A);
        System.out.println("time to make them equal is "+num);
    }
}
