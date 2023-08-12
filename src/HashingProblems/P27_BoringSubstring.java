package HashingProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
/*
You are given a string A of lowercase English alphabets.
Rearrange the characters of the given string A such that there is no boring substring in A.
A boring substring has the following properties:Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.
(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it is possible to rearrange the letters of A such that there are no boring
substrings in A else, return 0.

Problem Constraints
1 <= |A| <= 105
 */
/*
solution
put all the even character value together and all the odd value together
if all values are odd/even then gape between them is 2 so no problem
the main point if both even and odd are together the we have to finf a pair where the diff is more than 1 and we put
those pair in b/n and on one side we have even and on other side we have odd
 */
public class P27_BoringSubstring {
    public static int solve(String A) {
        //int i='c';
        //System.out.println(i);
        HashSet<Integer> even =new HashSet<>();
        HashSet<Integer> odd =new HashSet<>();
        for(int i=0;i<A.length();i++){
            int valofchar=A.charAt(i);
            if(valofchar%2==0){
                even.add(valofchar);//
            }
            else odd.add(valofchar);
        }
        for(int i:even){
            for (int j:odd){
                if(Math.abs(i-j)>1){
                    return 1;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        int possible=solve(S);
        System.out.println("Is it possible "+possible);

    }
}
