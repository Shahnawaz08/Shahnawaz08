package AdvanceDSA.Tries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Node2{
    char data;
    int freq;
    HashMap<Character,Node2> hm;
    Node2(char ch){
        data=ch;
        hm=new HashMap<>();
        freq=0;
    }
}
class Tries2{
    Node2 root;
    Tries2(){
        root=new Node2('\0');
    }
    void insert(String word){
        Node2 temp=root;
        for(int i=0;i<word.length();i++){
            char s=word.charAt(i);
            if(!temp.hm.containsKey(s)){
                Node2 n=new Node2(s);
                temp.hm.put(s,n);
            }
            //go to that node
            temp=temp.hm.get(s);
            temp.freq++;
        }

    }
    //Time complexity for 1 word :O(M)
    String prefix(String qword){
        Node2 temp=root;
        StringBuilder s= new StringBuilder();
        for(int i=0;i<qword.length();i++){
            char ch=qword.charAt(i);
            s.append(ch);
            if(temp.freq==1) break;

            temp=temp.hm.get(temp.data);
        }
        return s.toString();

    }

}
public class P2_ShortestUniquePrefix {


    public static String[] prefix(String[] A) {
        Tries2 root=new Tries2();
        for (String s : A) {
            root.insert(s);
        }
        String [] pref=new String[A.length];
        int i=0;
        for(String s:A){
            pref[i]= root.prefix(s);
            i++;
        }
        return pref;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        String [] A=new String[N];
        for(int i=0;i<N;i++){
            A[i]=sc.next();
        }
        String [] sortestpref=prefix(A);
        System.out.println(Arrays.toString(sortestpref));

    }
}
