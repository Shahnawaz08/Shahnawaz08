package HashingProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/*
Given a number A, find if it is COLORFUL number or not.

If number A is a COLORFUL number return 1 else, return 0.

What is a COLORFUL Number:

A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.


Problem Constraints
1 <= A <= 2 * 109
 */

public class P29_ColourFulNumber {
    public static int colorful(int A) {
        ArrayList<Integer> lst=new ArrayList<>();
        HashSet<Integer> hs=new HashSet<>();

        while (A>0){
            int n=A%10;
            A=A/10;
            //hs.add(n);
            if(!lst.isEmpty()){
               int size=lst.size();
               for(int i=0;i<size;i++){
                   int temp=lst.get(i);
                   System.out.println(temp);
                   System.out.println(lst);
                   if(hs.contains(temp*n)||hs.contains(n)){
                       System.out.println(temp);
                       return 0;
                   }
                   hs.add(temp*n);
                   lst.remove(i);
                   lst.add(i,temp*n);
               }
            }
            hs.add(n);
            lst.add(n);

        }
        return 1;
    }

    public static void main(String[] args) {
        int A=234;
        int is=colorful(A);
        System.out.println(is);
    }
}
