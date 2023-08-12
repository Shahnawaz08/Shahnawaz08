package HashingProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P26_CountRectangle {
    //making a function to store x ang y value
    public static String encode(int x,int y){
        String s=String.valueOf(x)+'@'+String.valueOf(y);
        return s;
    }
//here we are first taking two point on diagonal and search for other two point
    //if they other two are present then we increase the count
    //but we are counting twice once when we considering two points on one diagonal
    //and another time we are considering  points  of other diagonal of same rectangle
    //so we divide the answer by 2
    public static int solve(int[] A, int[] B) {
        int N=A.length;
        int cnt=0;
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<N;i++){
                set.add(encode(A[i],B[i]));
        }
        //System.out.println(set);
        for(int i=0;i<A.length-1;i++){
            for(int j=i+1;j<A.length;j++){
                if(A[i]==A[j]||B[i]==B[j]){
                    continue;
                }
                else {
                    int x1=A[i];
                    int y1=B[j];
                    int x2=A[j];
                    int y2=B[i];
                    String p3=encode(x1,y1);
                    String p4=encode(x2,y2);
                    if(set.contains(p3)&&set.contains(p4)){
                        cnt++;
                    }
                }
            }
        }
        //since we are counting same rectangle twice so we have to divide it by 2;
        cnt=cnt/2;

        return cnt;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int [] B=new int[N];
        for(int i=0;i<N;i++){
            B[i]=sc.nextInt();
        }
        int maxpointInstrightLine=solve(A,B);
        System.out.println("Maximum number of Rectangle  "+maxpointInstrightLine);
    }
}
