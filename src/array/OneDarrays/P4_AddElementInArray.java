package array.OneDarrays;

import java.util.Arrays;
import java.util.Scanner;

public class P4_AddElementInArray {
    public static void insert(int [] arr,int element,int pos){
       // System.out.println("size of array "+arr.length);
        for(int i=(arr.length/2)-1;i>=pos;i--){
            arr[i+1]=arr[i];
        }
        arr[pos]=element;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Size of am array ");
        int N=sc.nextInt();
        System.out.println();

        int [] arr=new int[2*N];
        System.out.print("Enter elements of an array ");
        for (int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println();
        System.out.print("Enter element to be inserted ");
        int num=sc.nextInt();
        System.out.println();
        System.out.print("Enter the position where element is inserted ");
        int pos=sc.nextInt();
        insert(arr,num,pos);
        System.out.println(Arrays.toString(arr));

    }
}
