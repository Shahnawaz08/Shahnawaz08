package HashingProblems;

import java.util.HashMap;
import java.util.Scanner;

public class P1_hashmap {
    public static int solve(int[] A) {
        HashMap< Integer,Integer > h1 = new HashMap<>();
        for (int elm:A) {
            int freq=h1.getOrDefault(elm,0);
            h1.put(elm,freq+1);
        }
        for (int ele:A) {
            if(h1.get(ele)>1){
                return ele;
            }
        }
        //System.out.println(h1);
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int no=solve(arr);
        System.out.println("First element occures is "+no);
    }
}
