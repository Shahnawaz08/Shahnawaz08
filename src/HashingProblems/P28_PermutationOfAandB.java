package HashingProblems;
/*
You are given two strings, A and B, of size N and M, respectively.
You have to find the count of all permutations of A present in B as a substring.
You can assume a string will have only lowercase letters.

Problem Constraints
1 <= N < M <= 105
 */

import java.util.HashMap;
import java.util.Scanner;

public class P28_PermutationOfAandB {
    public static int solve(String A, String B) {
        int cnt=0;
        int N=A.length();
        int M=B.length();
        //System.out.println("value of M "+M);
        HashMap<Character,Integer> orighm=new HashMap<>();
        for(int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            orighm.put(ch, orighm.getOrDefault(ch,0)+1);
        }
        //System.out.println(orighm);
        HashMap<Character,Integer> hm=new HashMap<>();
        int e=0;
        int s=0;
        while (e<N){
            char ch=B.charAt(e);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
            e++;
        }
        while (e<=M){
            //System.out.println(hm);

            /*
            int flag=1;
            for(char c: orighm.keySet()){
                if(hm.containsKey(c)){
                    if(orighm.get(c)!=hm.get(c)){
                        flag=0;
                        break;
                    }
                }
                else {
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                cnt++;
            }

             */
            //System.out.println("value of s "+s);
            //System.out.println("value of e "+e);

            // we can use predefined function to compare two hashmap
            if(orighm.equals(hm)){
                cnt++;
            }
            if(e!=M) {
                char rm = B.charAt(s);
                if (hm.get(rm) == 1) {
                    hm.remove(rm);
                } else {
                    hm.put(rm, hm.get(rm) - 1);
                }
                s++;
                char addchar = B.charAt(e);
                hm.put(addchar, hm.getOrDefault(addchar, 0) + 1);
            }
            e++;
        }
        //System.out.println(hm);
        //System.out.println(e);
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        int noOfPermut=solve(A,B);
        System.out.println(noOfPermut);
    }
}
