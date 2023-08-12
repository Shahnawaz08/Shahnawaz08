package HashingProblems;
/*
Given a string A consisting of lowercase characters.

Check if characters of the given string can be rearranged to form a palindrome.

Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
 */
import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

public class P6_CheckPalindromAfterRearrangement {
    public static int solve(String A) {
        int flag=0;
        HashMap<Character,Integer> h1=new HashMap<>();
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            if(h1.containsKey(ch)){
                int freq=h1.get(ch)+1;
                h1.put(ch,freq);
            }
            else{
                h1.put(ch,1);
            }
        }
        int countodd=1;
        Set<Character> keys=h1.keySet();
        for(Character ch:keys){
            //System.out.println(h1.get(ch));
            if(h1.get(ch)%2==1){
                countodd--;
            }
            if(countodd<0){
                return 0;
            }
        }


        //System.out.println(h1);
        return  1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        int n=solve(S);
        System.out.println(n);

    }

}
