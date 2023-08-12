package AdvanceDSA.StacksProblems;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class P7_MaximumRectangle {
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
    public static int solve(int[][] A) {
        int maxRect=-1;
        int rows=A.length;
        int cols=A[0].length;
        int ps[][]=new int[rows][cols];
        for(int j=0;j<cols;j++){
            for(int i=0;i<rows;i++){
                if(i==0){
                    ps[i][j]=A[i][j];
                }else {
                    if(A[i][j]==0){
                        ps[i][j]=0;
                    }else {
                        ps[i][j]=ps[i-1][j]+A[i][j];
                    }
                }
            }
        }
//        System.out.println(Arrays.deepToString(ps));
        for(int i=0;i<rows;i++){
            int [] arr=ps[i];
            int area=largestRectangleArea(arr);
            maxRect=Math.max(area,maxRect);
        }
        return maxRect;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter dimension of 2d Array");
        int N=sc.nextInt();
        int M=sc.nextInt();
        int [][] A=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j]=sc.nextInt();
            }
        }
        int maxRect=solve(A);
        System.out.println("Maximum sizr rectangle is "+maxRect);

    }
}
