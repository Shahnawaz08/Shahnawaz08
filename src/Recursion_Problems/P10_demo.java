package Recursion_Problems;

import java.util.Arrays;
import java.util.Scanner;

public class P10_demo {
    public static String [] rest(String [] a){
        String [] b= rev(a, a.length);
        String [] app1 = appendfun(a,"0");
        String [] app2 = appendfun(b,"1");
        String [] comp = merg(app1, app2);
        return  comp;
    }
    public static  String [] appendfun(String [] arr,String n){
        int len=arr.length;
        String[] b = new String[len];
        for(int i=0;i<len;i++){
             String temp=arr[i];
             temp=n+temp;
             b[i]=temp;

        }
        return b;
    }

    public static String [] rev(String [] arr,int n){

        String [] b = new String[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = arr[i];
            j = j - 1;
        }



        return b;
    }
    public static String[] merg(String [] A,String [] B){
        int n1=A.length;
        int n2=B.length;
        int n3=n1+n2;
        String [] C=new String[n3];
        for(int i=0;i<n1;i++){
            C[i]=A[i];
        }
        for(int i=0;i<n2;i++){
            C[n1+i]=B[i];
        }
    return C;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();


        String [] a=new String[2];
        a[0]="0";
        a[1]="1";
//        int n=3;
        for(int i=1;i<n;i++){
            String [] res=rest(a);
            a=res;
        }


        System.out.println(Arrays.toString(a));
        int [] b=new int[a.length];
        for(int i=0;i<a.length;i++){
            b[i]=Integer.parseInt(a[i],2);
        }


        System.out.println(Arrays.toString(b));





//        String [] res=rev(arr2,arr2.length);
//        System.out.println(Arrays.toString(res));
//        //String [] resStr=appendfun(arr2,"0");
//        //System.out.println(Arrays.toString(resStr));
//        String [] arr3=new String[2];
//        arr3[0]="1";
//        arr3[1]="0";
//        String [] res1=merg(arr2,arr3);
//        System.out.println(Arrays.toString(res1));



    }
}
