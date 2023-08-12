package Strings;

import java.util.Scanner;

public class P11_IndexOfOccurence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int B=sc.nextInt();
        int [] index=new int[A.length()];
        int count=0;
        for(int i=0;i<A.length();i++){
            if((int)A.charAt(i)==B){
                index[count]=i;
                count++;
            }
        }
        for(int i=0;i<count;i++){
            System.out.print(index[i]+" ");
        }
    }
}
