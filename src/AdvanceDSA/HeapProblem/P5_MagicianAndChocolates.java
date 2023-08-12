package AdvanceDSA.HeapProblem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P5_MagicianAndChocolates {
    public static int nchoc(int A, int[] B) {
        //here we create a max heap so that kid
        // can get max no of chocolate every time
        PriorityQueue <Integer> pq=new PriorityQueue<>(new CustomComp());
        long totalchoc=0;
        for(int i:B){
            pq.add(i);
        }
        while (!pq.isEmpty()&&A>0){
            int no=pq.poll();
            totalchoc=(totalchoc+no)%1000000007;
            //System.out.println(totalchoc);
            int halfno=no/2;
            if(halfno>0){
                pq.add(halfno);
            }
            A--;
        }
        return (int)totalchoc;
    }
    static class  CustomComp implements Comparator<Integer> {
        public int compare(Integer a,Integer b){
            return b-a;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int N=sc.nextInt();
        int [] B=new int[N];
        for(int i=0;i<N;i++){
            B[i]=sc.nextInt();
        }
        int maxChocolate=nchoc(A,B);
        System.out.println("Max chocolate that a kid will eat is "+maxChocolate);
    }
}
