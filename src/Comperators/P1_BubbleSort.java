package Comperators;

import java.util.Arrays;
import java.util.Scanner;

public class P1_BubbleSort {
    public static boolean compare(int a,int b){
//        return a<b; for decending
        return  a>b;
    }

    public static void bubbleSort(int [] arr){
        int n=arr.length;
        for(int itr=1;itr<=n-1;itr++){
            for(int j=0;j<=n-itr-1;j++){
                //if(arr[j]>arr[j+1]){
                if(compare(arr[j],arr[j+1])){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(A));
        bubbleSort(A);
        System.out.println(Arrays.toString(A));

    }

}
