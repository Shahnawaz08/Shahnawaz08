package AdvanceDSA.ModularArithmetic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class P2_pairSumDivisibleByM {
    public static int solve2(int[] A, int B) {
        HashMap<Integer,Long> hm=new HashMap<>();
        for(int i=0;i<A.length;i++){
            if(!hm.containsKey(A[i]%B)){
                hm.put(A[i]%B,1L);
            }else{
                hm.put(A[i]%B,(hm.get(A[i]%B)+1));
            }
        }

        long ans=0;
        long cnt0=hm.getOrDefault(0,0L);
        if(cnt0>=2){
            ans=(ans+((cnt0*(cnt0-1)))/2)%1000000007;
        }
        //System.out.println(ans);
        //System.out.println("b/2 " +B/2);
        for(int i=1;i<=B/2;i++){
            if(B%2==0&&i==B/2){
                ans = (ans + ((hm.getOrDefault(B / 2,0L) * (hm.getOrDefault(((B / 2) ),0L)-1))) / 2)%1000000007;

            }
            else {

                ans = (ans + (hm.getOrDefault(i,0L) * hm.getOrDefault(B - i,0L)))%1000000007;


            }
        }

        return (int)(ans%1000000007);
    }
    public static int solve(int[] A, int B) {
        long ans=0;
        int [] arr=new int[B];
        for(int i=0;i<A.length;i++){
            int index=A[i]%B;
            arr[index]=(arr[index]+1)%1000000007;
        }
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<B/2;i++){
            long emt=arr[i];
            //System.out.println(emt);
            if(i==0){
                if(emt>=2){
                    ans = (ans + (((emt * (emt - 1)) % 1000000007) / 2)) % 1000000007;
                }
            }
            else {
                ans=(ans+(emt*((long)arr[B-i]))%1000000007)%1000000007;
            }
        }

        if(B%2==0){
            long emt=arr[B/2];
            ans=(ans+((emt*(emt-1))%1000000007)/2)%1000000007;
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int B=sc.nextInt();

        int no=solve2(A,B);
        System.out.println(no);
    }
}
