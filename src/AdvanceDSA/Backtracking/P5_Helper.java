package AdvanceDSA.Backtracking;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Arrays;

public class P5_Helper {
    public static void main(String[] args) {
        Character [] s=new Character[5];
        int x=6;
        char a=(char)(x+'0');
        System.out.println(a-'0');
        String [] grid={ "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79" };
        char [][] chararray=new char[9][9];
        int i=0;
        for(String A:grid){
            char [] temp=A.toCharArray();
            chararray[i]=temp;
            i++;
        }
        System.out.println(Arrays.deepToString(chararray));

    }
}
