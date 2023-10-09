package general.easy;
/*
Find if Given number is power of 2 or not. More specifically, find if given number can be expressed as 2^k where k >= 1.

Input:

number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
Output:

return 1 if the number is a power of 2 else return 0
Example:

Input : 128
Output : 1
Expected Output
Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
 */

import java.math.BigInteger;
import java.util.Scanner;

public class P9_PowerOf2 {
    public static int power1(String A) {

        if(A.length()==1 && A.charAt(0)=='1'){
            return 0;
        }
        String dividend=A;
        while (dividend.length()>0) {
            //lets code division by 2
            int n=dividend.length();
            StringBuilder sb = new StringBuilder();
            if(n==1 && dividend.charAt(0)=='1'){
                return 1;
            }
            int lastdigit=dividend.charAt(n-1)-'0';
            if(lastdigit%2!=0){
                return 0;
            }

            int carry = 0;
            for (int i = 0; i < n; i++) {
                int digit = dividend.charAt(i) - '0';
                int number = digit + 10 * carry;
                carry = number % 2;
                int num = number / 2;
                sb.append(num);
            }
            if (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            dividend=sb.toString();
            //System.out.println(sb);
        }
        return 0;

    }
    public static int power(String A) {
        BigInteger number = new BigInteger(A);
        String str2="1";
        if(A.equals("1")){
            return 0;
        }

        // If the number is less than or equal to 0, it can't be a power of 2
        if (number.compareTo(BigInteger.ZERO) <= 0) {
            return 0;
        }

        // Check if the number is a power of 2 by counting the number of set bits
        int count = number.bitCount();
        if (count == 1) {
            return 1;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int a=power1(s);
        System.out.println(a);

    }
}
