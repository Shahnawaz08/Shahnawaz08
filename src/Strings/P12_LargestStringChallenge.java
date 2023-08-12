package Strings;

import java.util.Scanner;

public class P12_LargestStringChallenge {
    public static void main(String[] args) {
        //Question - Read N, followed by N lines, find out
        //the largest line based upon length
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();//nextline take one input from here
        String currentline;
        String Largestline="";
        int lrgLen=0;
       sc.nextLine();//to consume extra enter in the beginning
        for(int i=0;i<N;i++){
            currentline=sc.nextLine();
            if(currentline.length()>Largestline.length()){
                lrgLen=currentline.length();
                Largestline=currentline;
            }

        }
        System.out.println("Largest length is "+Largestline+" with length is "+lrgLen);

    }
}
