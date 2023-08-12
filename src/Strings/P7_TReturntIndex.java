/*
You are given a character string A, having length N and an integer ASCII code B.
You have to tell the leftmost occurrence of the character having ASCII
 code equal to B, in A or report that it does not exist.
 1 <= N <= 105
 A[i] ∈ ['a'-'z']
 97 <= B <= 122
 */

package Strings;

import java.util.Scanner;

public class P7_TReturntIndex {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int B=sc.nextInt();
        int index=-1;
        for(int i=0;i<A.length();i++){
            if((int)A.charAt(i)==B){
                index=i;
                break;
            }
        }
        System.out.println(index);
    }
}

