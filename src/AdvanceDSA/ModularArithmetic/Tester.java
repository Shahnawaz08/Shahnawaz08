package AdvanceDSA.ModularArithmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Tester {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String text = sc.nextLine();
        /*
        String[] arr = text.split(",");
        int count=0;
        for(String value:arr) {
            System.out.print(value + " ");
        }
        for (int i=0;i<arr.length;i++){
            count++;
        }
        System.out.println();
        System.out.println("count "+count);
             */
        List<String> list= new ArrayList<>(Arrays.asList(text.split(",")));
        System.out.println(list);


    }
}
