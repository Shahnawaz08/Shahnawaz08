package AdvanceDSA.BinarysearchPlaylist;

import java.util.Scanner;

public class P4_PivotInRotatedArray {
    public static int findPivot(int [] A){
        if(A.length==1){
            return 0;
        }
        int s=0;
        int e= A.length-1;
        int pivot=0;
        while (s<=e){
            int mid=(s+e)/2;
//            if(mid<=e &&A[mid]>A[mid+1] ){
//                pivot= mid+1;
//            }
//            else if(mid>=s &&A[mid]<A[mid+1]){
//                pivot=mid;
//            }
            int l,r;
            if(mid-1==-1){
                l=A[e];
            }
            else {
                l=A[mid-1];
            }
            if(mid==e){
                r=A[0];
            }else {
                r=A[mid+1];
            }
            if(l>A[mid]&&A[mid]<r){
                return mid;
            }
            if(l<A[mid]&&A[mid]>r){
                return mid+1;
            }


            if(A[mid]>A[s]){
                s=mid+1;
            } if(A[mid]<A[e])  {
                e=mid-1;
            }
        }
        return pivot;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }

        int index=findPivot(A);
        System.out.println("Index of  is piviot "+index);
    }
}
