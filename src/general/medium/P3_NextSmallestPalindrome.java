package general.medium;
/*
Problem Description

Given a numeric string A representing a large number you need to find the next smallest palindrome greater than this number.



Problem Constraints

1 <= |A| <= 100

A doesn't start with zeroes and always contain digits from 0-9.



Input Format

First and only argument is an string A.



Output Format

Return a numeric string denoting the next smallest palindrome greater than A.



Example Input

Input 1:

 A = "23545"
Input 2:

 A = "999"


Example Output

Output 1:

 "23632"
Output 2:

 "1001"
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P3_NextSmallestPalindrome {
    static int [] generateNextPalindrome(int num[], int n)
    {
//        System.out.println("Next Palindrome is:");

        // Input type 1: All the digits are 9,
        // simply o/p 1 followed by n-1 0's
        // followed by 1.
        ArrayList<Integer> arr=new ArrayList<>();
        if (isAll9(num, n)) {
            arr.add(1);
            for (int i = 0; i < n - 1; i++)
                arr.add(0);
            arr.add(1);
            return arr.stream().mapToInt(i->i).toArray();

        }

        // Input type 2 and 3
        else {
            generateNextPalindromeUtil(num, n);
            return num;
        }
    }
    // A utility function to check if num has all 9s
    static boolean isAll9(int num[], int n) {
        for (int i = 0; i < n; i++)
            if (num[i] != 9)
                return false;
        return true;
    }

    // Returns next palindrome of a given
    // number num[]. This function is for
    // input type 2 and 3
    static void generateNextPalindromeUtil(int num[], int n)
    {
        int mid = n / 2;

        // end of left side is always 'mid -1'
        int i = mid - 1;

        // Beginning of right side depends
        // if n is odd or even
        int j = (n % 2 == 0) ? mid : mid + 1;

        // A bool variable to check if copy of left
        // side to right
        // is sufficient or not
        boolean leftsmaller = false;

        // Initially, ignore the middle same digits
        while (i >= 0 && num[i] == num[j])
        {
            i--;
            j++;
        }

        // Find if the middle digit(s) need to
        // be incremented or not (or copying left
        // side is not sufficient)
        if (i < 0 || num[i] < num[j])
        {
            leftsmaller = true;
        }

        // Copy the mirror of left to tight
        while (i >= 0)
        {
            num[j++] = num[i--];
        }

        // Handle the case where middle digit(s)
        // must be incremented. This part of code
        // is for CASE 1 and CASE 2.2
        if (leftsmaller)
        {
            int carry = 1;

            // If there are odd digits, then increment
            // the middle digit and store the carry
            if (n % 2 == 1) {
                num[mid] += 1;
                carry = num[mid] / 10;
                num[mid] %= 10;
            }
            i = mid - 1;
            j = (n % 2 == 0 ? mid : mid + 1);

            // Add 1 to the rightmost digit of the left
            // side, propagate the carry towards MSB digit
            // and simultaneously copying mirror of the
            // left side to the right side.
            //when carry is zero no need to loop through till i>=0
            while (i >= 0 && carry>0)
            {
                num[i] = num[i] + carry;
                carry = num[i] / 10;
                num[i] %= 10;
                num[j] = num[i];// copy mirror to right
                i--;
                j++;
            }

        }
    }
    public static String solve(String A) {
        char [] Ch=A.toCharArray();
        int [] C=new int[Ch.length];
        for (int i=0;i<Ch.length;i++){
            C[i]=Ch[i]-'0';
        }
//        System.out.println(Arrays.toString(C));
        int [] nextPalindromeArray=generateNextPalindrome(C,C.length);
        //System.out.println(Arrays.toString(nextPalindromeArray));
        char [] nextPalindromeCharArray=new char[nextPalindromeArray.length];
        for(int i=0;i<nextPalindromeArray.length;i++){
//            char c=Character.forDigit(nextPalindromeArray[i],10);
            char c=(char)(nextPalindromeArray[i]+'0');
            nextPalindromeCharArray[i]=c;
            //System.out.println(nextPalindromeCharArray[i]);
        }
        return String.valueOf(nextPalindromeCharArray);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        String nextPalindrome=solve(S);
        System.out.println("Next smallest Palindrome after "+S+" is "+nextPalindrome);
    }
}
