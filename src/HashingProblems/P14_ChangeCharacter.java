package HashingProblems;
/*
Problem Description
You are given a string A of size N consisting of lowercase alphabets.
You can change at most B characters in the given string to any other lowercase alphabet
such that the number of distinct characters in the string is minimized.
Find the minimum number of distinct characters in the resulting string.
 */

import java.util.HashMap;
import java.util.Scanner;

public class P14_ChangeCharacter {
    public static int solve(String A, int B) {
        int maxOcc=-1;
        char maxch='0';
        HashMap<Character,Integer> h1=new HashMap<>();
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            int freq=h1.getOrDefault(ch,0)+1;
            h1.put(ch,freq);
            if(maxOcc<freq){
                maxOcc=freq;
                maxch=ch;
            }
        }
        System.out.println(h1);
        System.out.println(maxch+" "+maxOcc);
            for(char emt:h1.keySet()){
                if(emt!=maxch &&h1.get(emt)<=B){
                    int freq=h1.get(emt);
                    B=B-freq;
                    h1.put(emt,0);
                    //h1.remove(emt);
                    int freqMAxelement=h1.get(maxch)+freq;
                    h1.put(maxch,freqMAxelement);
                }
//                if(B==0){
//                    break;
//                }

            }

        int count=0;
        for(char ch:h1.keySet()){
            if(h1.get(ch)>0){
                count++;
            }
        }
        System.out.println(h1);
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        int B=sc.nextInt();
        int n=solve(S,B);
        System.out.println(n);

    }
}
