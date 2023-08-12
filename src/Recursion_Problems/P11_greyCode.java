package Recursion_Problems;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.Scanner;

public class P11_greyCode {
    public static ArrayList<Integer> togretcode(ArrayList<String> str1){
        ArrayList<Integer> Graycodeintarray=new ArrayList<>();
        int len=str1.size();
        for (int i=0;i<len;i++){
            int temp=Integer.parseInt(str1.get(i),2);
            Graycodeintarray.add(temp);
        }
        return Graycodeintarray;
    }

    public static ArrayList<String> appendval(ArrayList<String> arr,String val){
        int len=arr.size();
        for(int i=0;i<len;i++){
            String temp=val+arr.get(i);
            arr.set(i,temp);
        }
        return arr;
    }

    public static ArrayList<String> solve(ArrayList<String> arr){
       ArrayList<String> str1=new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            str1.add(arr.get(i).toString());
        }


//        ArrayList<String> str1=arr;
        ArrayList<String> str2=new ArrayList<>();
        for(int i=0;i<str1.size();i++){
            str2.add(str1.get(str1.size()-1-i));
        }
        str1=appendval(str1,"0");
        str2=appendval(str2,"1");
        str1.addAll(str2);
        return str1;

    }


    public static ArrayList<Integer> grayCode(int a) {
        if(a==1) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(0);
            arr.add(1);
            return arr;
        }
        ArrayList<Integer> arr = new ArrayList<>();

      return  arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        ArrayList<String> A = new ArrayList<>();
        A.add("0");
        A.add("1");
        ArrayList Arr=A;
        for(int i=1;i<a;i++) {
            Arr = solve(A);
            A=Arr;
        }
       System.out.println(Arr);
        ArrayList<Integer> greyy=togretcode(Arr);
        System.out.println(greyy);
    }

}
