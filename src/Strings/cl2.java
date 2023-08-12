package Strings;

public class cl2 {
    public static String solve(String A) {
        if(A.charAt(0)!='a'){
            return "no";
        }
        int ch='a';
        int Bcont=0;
       for(int i=1;i<A.length();i++){
           if(A.charAt(i)=='a'||A.charAt(i)=='b'){
               if(A.charAt(i)=='a' && Bcont==0){
                   continue;
               }
               else if(A.charAt(i)=='b'){
                   Bcont=1;
               }
               else{
                   return "no";
               }

           }
           else{
               return "no";
           }


       }
       return "yes";


    }

    public static void main(String[] args) {
        String s="aaabba";
        String res=solve(s);
        System.out.println(res);
    }
}
