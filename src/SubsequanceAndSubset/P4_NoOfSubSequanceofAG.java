package SubsequanceAndSubset;

import java.util.Scanner;
/*
You have given a string A having Uppercase English letters.
You have to find how many times subsequence "AG" is there in the given string.
NOTE: Return the answer modulo 109 + 7 as the answer can be very large
 */

public class P4_NoOfSubSequanceofAG {
    public static int solve(String A) {
        int count=0;
        int ans=0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='A'){
                ans++;
            }
            if(A.charAt(i)=='G'){
                count+=ans;
                count=count%1000000007;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S= sc.next();
        int countOfSubsequance=solve(S);
        System.out.println("No of substring AG "+countOfSubsequance);
    }
}
