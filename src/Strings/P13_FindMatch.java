package Strings;

import java.sql.SQLOutput;

public class P13_FindMatch {

    public static void main(String[] args) {
        String paragraph="we are learning java programming. java is very powerfull" +
                "java java java ";
        String word="java";
       /* int occ=(paragraph.indexOf(word));
        System.out.println(occ);
        occ=paragraph.indexOf(word,occ+1);
        System.out.println(occ);
        */
        int occ=(paragraph.indexOf(word));
        while(occ!=-1){
            System.out.println(occ);
            occ=paragraph.indexOf(word,occ+1);
        }

    }
}
