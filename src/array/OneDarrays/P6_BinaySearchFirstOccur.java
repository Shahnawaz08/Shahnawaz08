package array.OneDarrays;

import java.util.Scanner;

public class P6_BinaySearchFirstOccur {

    public static int binarySearchFirstOcc(int[] arr,int element){
        int s=0;
        int e= arr.length-1;
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(arr[mid]==element){
                ans=mid;
                e=mid-1;
            }
            else if(arr[mid]<element){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return ans;
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
        int index= binarySearchFirstOcc(arr,num);
        System.out.println("Index of "+num+" is "+index);
    }
}
