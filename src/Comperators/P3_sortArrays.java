package Comperators;

import java.util.Arrays;
import java.util.Scanner;

public class P3_sortArrays {
    public static boolean compare(int [] a,int [] b){
//        return a<b; for decending
        int l1=a.length;
        int l2=b.length;
        int min=l1<l2?l1:l2;
        for(int i=0;i<min;i++){
            if(a[i]<b[i]){
                return false;
            }
            if(a[i]>b[i]){
                return true;
            }
        }
        if(l1<l2){
            return false;
        }
        return true;
    }
    public static void bubbleSortArrays(int [][] arr){
        int n=arr.length;
        for(int itr=1;itr<=n-1;itr++){
            for(int j=0;j<=n-itr-1;j++){
                //if(arr[j]>arr[j+1]){
                if(compare(arr[j],arr[j+1])){
                    int [] temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int [][] A={{1,2},{0,3},{0,2},{6,3},{1,2}};
        System.out.println(Arrays.deepToString(A));
        bubbleSortArrays(A);
        System.out.println(Arrays.deepToString(A));

    }
}
