package Strings.Intermediate;

import java.util.Scanner;

public class P10_longestCommonPrefix {
    public static void longestCommonPrefix(StringBuilder cprifix,String S){
        int i=0;
        int l= cprifix.length();
        int N=S.length();
        while (i<l&&i<N){
            if(cprifix.charAt(i)!=S.charAt(i)){
                break;
            }
            i++;
        }
        cprifix.delete(i,l);
        //System.out.println(cprifix);
    }
    public static String longestCommonPrefix(String[] A) {
        StringBuilder sb=new StringBuilder();
        sb.append(A[0]);
        for(int i=1;i<A.length;i++){
            longestCommonPrefix(sb,A[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        String [] S=new String[N];
        for(int i=0;i<N;i++){
            S[i]=sc.next();
        }
        //System.out.println(S);
        String longPrefix=longestCommonPrefix(S);
        System.out.println(longPrefix);

    }
}
