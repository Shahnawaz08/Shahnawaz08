package Strings.Intermediate;
/*
Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
 Find and return the length of the longest consecutive 1’s that can be achieved.
 */

import java.util.Scanner;

public class P5_longestStringWIth1 {
    public static int solve(String A) {
        int N=A.length();
        int countOfOne=0;
        for(int i=0;i<N;i++){
            if(A.charAt(i)=='1'){
                countOfOne++;
            }
        }
        System.out.println("length of string "+N);
        System.out.println("count of i "+countOfOne);
        int maxlen=Integer.MIN_VALUE;
        int left=0;
        int right=0;
        for(int i=0;i<N;i++){

            if(A.charAt(i)=='1'){
                while (i<N && A.charAt(i)=='1'){
                    left++;
                    i++;
                }
            }
            if(i<N-1 && A.charAt(i)=='0' && A.charAt(i+1)=='1'){
                i++;
                while (i<N && A.charAt(i)=='1'){
                    right++;
                    i++;
                }
                i--;
            }
            int len=left+right;
            System.out.println(left+" "+right);
            if(len==countOfOne){
                maxlen=Math.max(maxlen,len);
            } else if (len<countOfOne) {
                len=len+1;
                maxlen=Math.max(maxlen,len);
            }
            left=right;
            right=0;
            System.out.println("left= "+left+" right= "+right);
        }


        return maxlen;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        int n=solve(S);
        System.out.println("Length of longest consecutive 1 we can made "+n);

    }
}
