package array.OneDarrays;

import java.util.Arrays;
import java.util.Scanner;

public class P5_BinarySearch {
    //no profit since in worst case it runs N times
    public static int binarySearchForrLoop(int[] arr,int element){
        int s=0;
        int e= arr.length-1;
        for(int i=0;i<arr.length;i++){
            int mid=(s+e)/2;
            if(arr[mid]==element){
                return mid;
            }
            else if(arr[mid]<element){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr,int element){
        int s=0;
        int e= arr.length-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(arr[mid]==element){
                return mid;
            }
            else if(arr[mid]<element){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        // Read N elements,loop runs N times
        System.out.print("Enter the "+N+" Elements : ");
        for (int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println();
        System.out.print("Enter the element to find ");
        int num= sc.nextInt();
        int index= binarySearch(arr,num);
        System.out.println("Index of "+num+" is "+index);
    }
}
