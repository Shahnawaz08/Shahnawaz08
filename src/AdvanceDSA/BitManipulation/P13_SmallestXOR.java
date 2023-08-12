package AdvanceDSA.BitManipulation;
/*
Given two integers A and B, find a number X such that A xor X is minimum possible,
 and the number of set bits in X equals B.
 */
import java.util.Arrays;
import java.util.Scanner;

public class P13_SmallestXOR {
    public static int solve(int A, int B) {
        int size_A=0;
        int ans=0;
        int Acopy=A;
        while (Acopy!=0 ){
            int set=Acopy&1;
            if(set>0) {
                size_A++;
            }
            Acopy=Acopy>>1;

        }
        //System.out.println(size_A);
        for(int i=0;i<=31;i++){
            int mask=1<<i;
            int set=A&mask;
            if(set==0&&B>size_A){
                ans=ans |mask;
                B--;
            } else if (set>0 && size_A>B) {
                size_A--;
            }
            else {
                ans =ans |set;
            }


        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();

        int no=solve(A,B);
        System.out.println(no);
    }
}
