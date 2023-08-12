package AdvanceDSA.Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class P8_GrayCode {
    public static ArrayList<Integer> grayCodeRec(int a) {
        ArrayList<Integer> arr=new ArrayList<>();
        if(a==1){
            arr.add(0);
            arr.add(1);
            return arr;
        }
        arr=grayCode(a-1);
        int mask=1<<(a-1);
        for (int i=arr.size()-1;i>=0;i--){
            arr.add(mask|arr.get(i));
        }
        return arr;
    }
    public static ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(0);
        for(int i=1;i<=a;i++){
            int mask=1<<(i-1);
            for(int j=arr.size()-1;j>=0;j--){
                arr.add(mask|arr.get(j));
            }
        }
        return arr;
    }
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        ArrayList<Integer> graylist=grayCode(A);
        System.out.println(graylist);
        ArrayList<Integer> graylist2=grayCodeRec(A);
        System.out.println(graylist2);
    }
}
