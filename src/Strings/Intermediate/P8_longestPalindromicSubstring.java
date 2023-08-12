package Strings.Intermediate;

import java.util.Scanner;

public class P8_longestPalindromicSubstring {
    public static int lenOfpalindrom(String A ,int leftidx,int rightidx){
        int lenofplad=0;
        while(leftidx>=0&&rightidx<A.length()){
            if(A.charAt(leftidx)!=A.charAt(rightidx)){
                break;
            }
            rightidx++;
            leftidx--;
        }
        lenofplad=rightidx-leftidx-1;
        return lenofplad;

    }
    public static String longestPalindrome(String A) {
        int maxlen=0;
        int leftidx=0;
        int rightidx=0;
        for(int i=0;i<A.length();i++){
            int len=lenOfpalindrom(A,i,i);
            if(len>maxlen){
                maxlen=len;
                leftidx=i-len/2;
                rightidx=i+len/2;
            }
        }
        for(int i=0;i<A.length()-1;i++){
            int len=lenOfpalindrom(A,i,i+1);
            if(len>maxlen){
                maxlen=len;
                leftidx=i-(len/2-1);
                rightidx=i+1+(len/2)-1;
            }
        }
        System.out.println("length of max palindrome  "+maxlen);
        String longestPldrom="";
        for(int i=leftidx;i<=rightidx;i++){
            longestPldrom+=A.charAt(i);
        }
        return longestPldrom;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.nextLine();
        //System.out.println(S);
        String S_pland=longestPalindrome(S);
        System.out.println(S_pland);

    }
}
