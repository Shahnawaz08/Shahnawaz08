package AdvanceDSA.BinarysearchPlaylist;
//find how many numbers are smaller or equal to B;
import java.util.Scanner;

public class P0_BinarySearchInSortedArray {
    public static int searchnoless(int [] A,int B){
        int index=0;
        int s=0;
        int e=A.length-1;
        while (s<=e){
            int mid=(s+e)/2;
            if(A[mid]>B){
                e=mid-1;
            }
            else if(A[mid]==B){
                index=mid;
                s=mid+1;
            }
            else{
                index=mid+1;
                s=mid+1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Target element");
        int B=sc.nextInt();
        int index=searchnoless(A,B);
        System.out.println("Index of "+B+" is "+index);
    }
}
