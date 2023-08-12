package Strings;

public class P2_StringBasic {
    public static void main(String[] args) {
        String s1="hi";
        String s2="hi";
        System.out.println(s1);
        System.out.println(s2);
        if(s1==s2){
            System.out.println("Sting Matched");
        }
        String a=new String("Hi");
        String b=new String("Hi");
        System.out.println(a);
        System.out.println(b);
        if(a==b){
            System.out.println("Sting Matched Again");
        }
        System.out.println(a.equals(b));
        System.out.println(s1.equals(s2));
        System.out.println("a".compareTo("b"));
        System.out.println("a".compareTo("ad"));

    }
}
