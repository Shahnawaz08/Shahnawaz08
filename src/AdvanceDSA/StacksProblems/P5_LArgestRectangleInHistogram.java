package AdvanceDSA.StacksProblems;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class P5_LArgestRectangleInHistogram {
    public static int[] prevSmaller(int[] A) {//we are storing the index of smaller element
        Stack<Integer> S=new Stack<>();
        int N=A.length;
        int [] res=new int[N];
        for(int i=0;i<N;i++){
            while (!S.isEmpty()&&A[S.peek()]>=A[i]){
                S.pop();
            }
            if(S.isEmpty()){
                res[i]=-1;

            }
            else {
                res[i]=S.peek();
            }
            S.add(i);
        }
        return res;
    }
    public static int[] nextSmaller(int[] A) {//storing index of smaller element
        Stack<Integer> S=new Stack<>();
        int N=A.length;
        int [] res=new int[N];
        for(int i=N-1;i>=0;i--){
            while (!S.isEmpty()&&A[S.peek()]>=A[i]){
                S.pop();
            }
            if(S.isEmpty()){
                res[i]=-1;

            }
            else {
                res[i]=S.peek();
            }
            S.add(i);
        }
        return res;
    }
    public static int  largestRectangleArea(int[] A) {
        int largestRec =-1;
        int N=A.length;
        int [] prevSmall=prevSmaller(A);
        int [] nextSmall=nextSmaller(A);
        //System.out.println(Arrays.toString(prevSmall));
        //System.out.println(Arrays.toString(nextSmall));
        for(int i=0;i<N;i++){
            int height=A[i];
            int leftindex=prevSmall[i];
            int rightindex=nextSmall[i];
            if(rightindex==-1){
                rightindex=N;
            }
            int breath=rightindex-leftindex-1;
            int rec=height*breath;
            largestRec=Math.max(rec,largestRec);
        }
        return largestRec;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int MaxRect=largestRectangleArea(A);
        System.out.println(MaxRect);
    }
}
