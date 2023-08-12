package Strings.Intermediate;
/*
You are given a string A of size N consisting of lowercase alphabets.
You can change at most B characters in the given string to any other
lowercase alphabet such that the number of distinct characters in the string is minimized.
Find the minimum number of distinct characters in the resulting string.
 */

import java.util.Arrays;
import java.util.Scanner;

public class P11_ChangeCharacter {
    public static int solve(String A,int B){
        int [] freq=new int[26];
        int maxval=Integer.MIN_VALUE;
        int maxindex=-1;
        for (int i=0;i<A.length();i++){
            char ch=A.charAt(i);
            int ch_int=ch-'a';
            freq[ch_int]++;
            if(freq[ch_int]>maxval){
                maxval=freq[ch_int];
                maxindex=ch_int;
            }
        }
        //System.out.println(Arrays.toString(freq));
        //System.out.println(maxindex+" "+maxval);
        while (B>0){
            int min=Integer.MAX_VALUE;
            int minindex=-1;
            for(int i=0;i<26;i++){
                if(freq[i]<min&&freq[i] !=0){
                    min=freq[i];
                    minindex=i;
                }
            }
        System.out.println(minindex+" "+min);
            if(B>=freq[minindex]){
                B=B-min;
                freq[maxindex]=freq[maxindex]+freq[minindex];
                freq[minindex]=0;
            }
            else {
                freq[maxindex]=freq[maxindex]+B;
                freq[minindex]=freq[minindex]-B;
                B=0;
            }
        }
        //System.out.println(Arrays.toString(freq));
        int countofUniqele=0;
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                countofUniqele++;
            }
        }
        return countofUniqele;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        int B= sc.nextInt();
        int remdiffCgar=solve(S,B);
        System.out.println(remdiffCgar);
    }
}
