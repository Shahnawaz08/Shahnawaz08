package Strings.Intermediate;

import java.util.Scanner;

public class P2_NoOfSubSequanceOfAG {
    public static int solve(String A) {
        int N=A.length();
        int count=0;
        int ans=0;
        for(int i=0;i<N;i++){
            if(A.charAt(i)=='A'){
                count++;
            }
            else if(A.charAt(i)=='G'){
                ans+=count;
            }
        }
        ans=ans%(10000007);
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int x=solve(A);
        System.out.println("No of occurance of AG is "+x);
    }
}
