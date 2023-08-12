package AdvanceDSA.QueuesProblems;
/*
Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
B is formed such that we have to find the first non-repeating character each time a character
is inserted to the stream and append it at the end to B. If no non-repeating character is found,
 append '#' at the end of B.

Problem Constraints
1 <= |A| <= 100000
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P5_FirstNon_RepeatingChar {
    public static String solve(String A) {
        HashMap<Character,Integer> hm=new HashMap<>();
        Queue<Character> qu=new LinkedList<>();
        String res="";
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            if(!hm.containsKey(ch)){
                hm.put(ch,1);
                qu.add(ch);
            }
            else {
                hm.put(ch,hm.get(ch)+1);
                if(!qu.isEmpty()&&qu.peek()==ch){
                    qu.remove();
                }
                while(!qu.isEmpty()&&hm.get(qu.peek())!=1){
                    qu.remove();
                }
            }
            if(!qu.isEmpty()){
                res+=qu.peek();
            }
            else {
                res+='#';
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        String res=solve(S);
        System.out.println("FIrst Non repeating charcters string "+res);

    }
}
