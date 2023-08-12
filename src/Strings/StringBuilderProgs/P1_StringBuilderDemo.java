package Strings.StringBuilderProgs;

public class P1_StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("Hello");
        sb.ensureCapacity(100);
        sb.insert(1,"ee");
        sb.insert(6,'o');
        System.out.println(sb);
        sb.append(" Boys");
        System.out.println(sb);
        System.out.println(sb.length());
        String s=sb.toString();
        System.out.println(s);
        String sn="Heeelloo Boys";
        if(s==sn){
            System.out.println("they are equal");
        }
        /*
        long a=10;
        System.out.println(s.getClass().getSimpleName());
        System.out.println(sb.getClass().getSimpleName());
        System.out.println(((Object)a).getClass().getSimpleName());
        Object o=a;
        System.out.println(o.getClass());
         */

    }
}
