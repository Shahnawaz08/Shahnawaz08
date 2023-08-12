package HashingProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P5_longestSubArraySumZero {
    public static int [] solve(int[] A) {
        long sum=0;
        HashMap<Long,Integer> h1=new HashMap<>();
        int start=-1;
        int end=-1;
        int flag=0;
        int maxlen=0;

        for(int i=0;i<A.length;i++){
            sum+=A[i];
            if(h1.containsKey(sum)){
                //System.out.println(sum);
                int tstart=h1.get(sum)+1;
                int tend=i;
                if(tend-tstart+1>maxlen) {
                    maxlen=tend-tstart+1;
                    start = h1.get(sum) + 1;
                    end = i;
                    flag = 1;
                }
            }
            if(sum==0){

                int tstart=0;
                int tend=i;
                System.out.println("i am in zero condition in outsside "+tstart+" "+tend);
                if(tend+1>maxlen) {
                    maxlen=tend+1;
                    start = 0;
                    end = i;
                    System.out.println("i am in zero condition "+start+" "+end+" maxlen is ");
                    flag = 1;
                }
            }
            if(!h1.containsKey(sum)){
                h1.put((long)sum,i);
                System.out.print(h1.keySet());

            }
        }

        System.out.println(start+" "+end);
        int N=end-start+1;
        int [] arr=new int[N];
        if(end==-1&&start==-1||flag==0){
            return null;
        }
        int idx=0;
        for(int i=start;i<=end;i++){
            arr[idx]=A[i];
            idx++;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size and element");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }

        int [] zeroSubArrayPresent=solve(A);
        System.out.println("Zero sub array present "+ Arrays.toString(zeroSubArrayPresent));


    }
}
