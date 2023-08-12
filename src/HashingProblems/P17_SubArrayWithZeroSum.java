package HashingProblems;

import java.util.HashSet;
import java.util.Scanner;

public class P17_SubArrayWithZeroSum {
    public static int solve(int[] A) {
        int N=A.length;
        HashSet<Long> set=new HashSet<>();
        long [] ps=new long[N];
        ps[0]=A[0];
        set.add(ps[0]);
        for(int i=1;i<N;i++){
            ps[i]=A[i]+ps[i-1];
            if(ps[i]==0){
                return 1;
            }
            if(set.contains(ps[i])){
                return 1;
            }
            else {
                set.add(ps[i]);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int no=solve(arr);
        System.out.println("sub-array with zero "+no);
    }
}
