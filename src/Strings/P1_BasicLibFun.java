package Strings;

import java.util.Locale;

public class P1_BasicLibFun {
    public static void main(String[] args) {
        String sc="Titanic ship is sailing";
        System.out.println(sc.toUpperCase());
        System.out.println(sc.toLowerCase());
        //Search operation
        System.out.println(sc.contains("ship"));
        System.out.println(sc.contains(" ship"));
        System.out.println(sc.contains("  ship"));
        System.out.println(sc.contains("nic"));

        //Regular expression'
        System.out.println(sc.matches(".*nic.*"));

    }
}
