package HashingProblems;
/*
Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in
linear time complexity.
Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.

Note:

If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )


Problem Constraints
1 <= size(A), size(B) <= 106
 */

import java.util.HashMap;
import java.util.Scanner;

public class P31_WindowString {
    public static String minWindow(String A, String B) {
       int N=A.length();
       int M=B.length();
       HashMap<Character,Integer> origial=new HashMap<>();
       int [] countArray=new int[300];

       for(int i=0;i<M;i++){
           char ch=B.charAt(i);
           origial.put(ch,origial.getOrDefault(ch,0)+1);
       }
        //System.out.println(origial);
       int s=-1;
       int e=0;
       int start=-1;
       int end=-1;
       int minlen=Integer.MAX_VALUE;
        HashMap<Character,Integer> hm=new HashMap<>();
       while (e<=N){
//           char ch=A.charAt(e);
           if(hm.equals(origial)){
               while (hm.equals(origial)){
                   s++;
                   char charatS=A.charAt(s);
                   if(hm.containsKey(charatS)){
                       if(countArray[charatS-'0']>0){
                           countArray[charatS-'0']--;
                       }
                       else {
                           if(hm.get(charatS)==1){
                               hm.remove(charatS);
                           }
                           else {
                               hm.put(charatS,hm.get(charatS)-1);
                           }
                       }
                   }
               }
               for(int i=s;i<=e-1;i++){
                   System.out.print(A.charAt(i));

               }
               System.out.println();
               if (minlen > (e - s + 2)) {

                   start=s;
                    end=e-1;
                    minlen=(e-s+2);



               }
           }
           else {
               if(e<N) {
                   char ch = A.charAt(e);
                   if (origial.containsKey(ch)) {
                       if (origial.get(ch) > hm.getOrDefault(ch, 0)) {
                           hm.put(ch, hm.getOrDefault(ch, 0) + 1);
                       } else {
                           int idx = ch - '0';
                           countArray[idx]++;
                       }

                   }
               }
           }

           e++;
       }
        System.out.println("hii");
       if(start==-1){
           return "";
       }
       StringBuilder str=new StringBuilder();
       for(int i=start;i<=end;i++){
           str.append(A.charAt(i));
       }
       return str.toString();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        String res=minWindow(A,B);
        System.out.println(res);
    }
}
