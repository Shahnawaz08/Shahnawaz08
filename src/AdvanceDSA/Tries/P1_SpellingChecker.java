package AdvanceDSA.Tries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Node{
    char data;
    boolean isTerminal;
    HashMap<Character,Node> hm;
    Node(char ch){
        data=ch;
        hm=new HashMap<>();
        isTerminal=false;
    }
}
class Tries{
    Node root;
    Tries(){
        root=new Node('\0');
    }
    void insert(String word){
        Node temp=root;
        for(int i=0;i<word.length();i++){
            char s=word.charAt(i);
            if(!temp.hm.containsKey(s)){
                Node n=new Node(s);
                temp.hm.put(s,n);
            }
            //go to that node
            temp=temp.hm.get(s);
        }
        //last node as terminal node
        temp.isTerminal=true;
    }
    //Time complexity for 1 word :O(M)
    boolean search(String qword){
        Node temp=root;
        for(int i=0;i<qword.length();i++){
            char s=qword.charAt(i);
            if(temp.hm.containsKey(s)){
                //go to that node if present
                temp=temp.hm.get(s);
            }else {
                return false;
            }
        }
        //check the terminal node
        return  temp.isTerminal;
    }

}




public class P1_SpellingChecker {
    public static int[] solve(String[] A, String[] B) {
        Tries root=new Tries();
        for (int i=0;i<A.length;i++){
            String s=A[i];
            root.insert(s);

        }
        int [] res=new int[B.length];
        for (int i=0;i<B.length;i++){
            boolean r=root.search(B[i]);
            if(r){
                res[i]=1;
            }else {
                res[i]=0;
            }


        }
        return res;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        String [] A=new String[N];
        for(int i=0;i<N;i++){
            A[i]=sc.next();
        }
        int M=sc.nextInt();
        String [] B=new String[M];
        for(int i=0;i<M;i++){
            B[i]=sc.next();
        }
        int [] res=solve(A,B);
        System.out.println(Arrays.toString(res));
    }
}
