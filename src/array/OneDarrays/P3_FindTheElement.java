package array.OneDarrays;

import java.util.Arrays;
import java.util.Scanner;

public class P3_FindTheElement {
    public static int search(int[] arr,int element){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==element){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        // Read N elements,loop runs N times
        for (int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int num= sc.nextInt();
        int index= search(arr,num);
        System.out.println("Index of "+num+" is "+index);
    }
}
