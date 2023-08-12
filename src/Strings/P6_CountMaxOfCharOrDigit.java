package Strings;
//You have to tell the count of characters
//        of the maximum occuring character type.
//   The string consists of 2 types of characters:
//
//           Alphabets : ['a'-'z', 'A'-'Z']
//           Digits: ['0'-'9']

import java.util.Scanner;


public class P6_CountMaxOfCharOrDigit {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
//        char digit ='0';
//        char digit2 ='9';
//        char Astaet='A';
//        System.out.println((int)digit);
//        System.out.println((int)digit2);
//        System.out.println((int)Astaet);
        int Dcount=0;
        int Acount=0;
        for(int i=0;i<A.length();i++){
            if((int)A.charAt(i)>=48 && (int)A.charAt(i)<=57){
                Dcount++;
            }
            else{
                Acount++;
            }
        }
        if(Dcount>Acount){
            System.out.println(Dcount);
        }
        else{
            System.out.println(Acount);
        }


    }
}
