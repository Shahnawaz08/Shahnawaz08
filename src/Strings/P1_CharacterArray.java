package Strings;

public class P1_CharacterArray {
    public static void main(String[] args) {
        char arr[]={'a','b','c'};
        arr[0]='x';
        System.out.println(arr);
        String st=arr.toString();
        System.out.println(st);

        String s="abc";
        char [] to_char=s.toCharArray();
        to_char[1]='j';
        System.out.println(to_char);
        System.out.println(s);
        s=new String(to_char);
        System.out.println("new stings is "+s);
    }
}
