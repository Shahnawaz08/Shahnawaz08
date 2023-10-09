package AdvanceDSA.BinarysearchPlaylist;

import java.util.Scanner;

public class P14_FoodPacketDistribution {
    public static boolean check(int [] A,int mid,int B){
        int req=0;
        for(int i=0;i<A.length;i++){
            req+=A[i]/mid;
        }
        System.out.println(req +" req");
        if(req>=B){
            return true;
        }
        return false;
    }
    public static int solve(int[] A,int B){
        int ans=0;
        long sum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            min=Math.min(min,A[i]);
        }
        if(sum<B){
            return 0;
        }
        int l=1;
        int r=min;
        System.out.println(l+" "+min);
        while (l<=r){
            int mid=(l+r)/2;
            System.out.println("Mid "+mid);
            if(check(A,mid,B)){
                System.out.println("Inside check");
                ans=mid;
                l=mid+1;
            }
            else {
                r=mid-1;
            }
        }
        System.out.println("outsefe "+ans);

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int B=sc.nextInt();
        char c=(char)('A'+2);
        System.out.println(c);
        int minNoOfPeople=solve(A,B);
        System.out.println("max of Min number of people who can eat in single office is  "+minNoOfPeople);
    }
}
