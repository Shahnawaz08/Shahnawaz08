package Recursion_Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P12_IsDictionary {
    public static int solve(String[] A,String B) {
        HashMap<Character,Integer> h1=new HashMap<>();
        int lenofString=B.length();
        if(B==""){
            return 0;
        }
        for(int i=0;i<lenofString;i++){
            char ch=B.charAt(i);
            h1.put(ch,i);
        }

        for(int i=0;i<A.length-1;i++){
            String temp1=A[i];
            String temp2=A[i+1];
            int len= Math.min(temp1.length(), temp2.length());
            for(int j=0;j<len;j++){
                if(h1.get(temp1.charAt(j))<h1.get(temp1.charAt(j))){
                    break;
                } else if (h1.get(temp1.charAt(j))>h1.get(temp1.charAt(j))) {
                    return 0;
                }
            }if(temp1.length()>temp2.length()){
                return 0;
            }

        }
        //System.out.println(h1);
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String B= sc.next();
        int N=sc.nextInt();
        String [] A=new String[N];
        for(int i=0;i<N;i++){
            A[i]=sc.next();
        }
        int issort=solve(A,B);
        System.out.println(issort);
    }
}
