package HashingProblems;

import java.util.*;

public class P7_KOccurance {
    public static int getSum(int A, int B, int[] C) {
        int sum=0;
        HashMap<Integer,Integer> h1=new HashMap<>();
        for(int elm:C){
            if(h1.containsKey(elm)){
                int freq=h1.get(elm);
                h1.put(elm,freq+1);
            }
            else{
                h1.put(elm,1);
            }
        }
        Set<Integer> keys=h1.keySet();
        for(Integer ch:keys){
            //System.out.println(h1.get(ch));
            if(h1.get(ch)==B){
                sum+=ch;
            }
        }
        return sum;
    }




    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size and element");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("No of occurance ");
        int B=sc.nextInt();

        int sumOfheight=getSum(N,B,A);
        System.out.println(sumOfheight);
    }
}
