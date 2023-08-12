package array.IntermidiateArrays;

import java.util.Scanner;
/*
Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and
return the length of the longest consecutive 1’s that can be achieved.
 */

public class P24_LongestString {
    public static int solve(String A) {
        int N=A.length();
        int countOfOne=0;
        for(int i=0;i<N;i++){
            if(A.charAt(i)=='1'){
                countOfOne++;
            }
        }

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
            if(len==countOfOne){

                maxlen=Math.max(maxlen,len);
            } else if (len<countOfOne) {
                len=len+1;
                maxlen=Math.max(maxlen,len);
            }
            left=right;
            right=0;
        }


        return maxlen;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        int len=solve(S);
        System.out.println(len);
    }
}
