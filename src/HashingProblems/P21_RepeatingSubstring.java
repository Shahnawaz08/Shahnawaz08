package HashingProblems;
/*
Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.

Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".

If it is possible, return 1, else return -1.



Problem Constraints

1 <= Length of string B <= 1000

1 <= A <= 1000

All the alphabets of S are lower case (a - z)
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P21_RepeatingSubstring {
    public static int solve(int A, String B) {
        int N=B.length();
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<N;i++){
            hm.put(B.charAt(i),hm.getOrDefault(B.charAt(i),0)+1);
        }
        for(char c: hm.keySet()){
            if(hm.get(c)%A!=0){
                return -1;
            }
        }
        return 1;
    }

        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        String B=sc.next();

        int pos=solve(A,B);
        if(pos==1) {
            System.out.println("Repeating Substring is possible");
        }else {
            System.out.println("Repeating substring is not possible");
        }
    }
}
