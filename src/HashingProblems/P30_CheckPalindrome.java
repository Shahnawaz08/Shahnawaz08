package HashingProblems;
/*
Given a string A consisting of lowercase characters.

Check if characters of the given string can be rearranged to form a palindrome.

Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.



Problem Constraints
1 <= |A| <= 105

A consists only of lower-case characters.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P30_CheckPalindrome {
    public static int solve(String A) {
        int n=A.length();
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(A.charAt(i),hm.getOrDefault(A.charAt(i),0)+1);

        }
        System.out.println(hm);
        int cntOfOne=0;
        int cntOfTwo=0;
        for(char ch:hm.keySet()){
            if(hm.get(ch)%2==0){
                cntOfTwo++;
            }
            else cntOfOne++;
        }
        if(cntOfOne==0||cntOfOne==1) return 1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int ispalindome=solve(A);
        System.out.println(ispalindome);
    }
}
