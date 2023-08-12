package SubsequanceAndSubset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class P7_SubsequenceSumProblem {
    public static int solve(int[] A, int B) {
        int size=A.length;
        int binary=1<<size;
        for(int i=0;i<binary;i++){
            ArrayList<Integer> subset=new ArrayList<>();
            int temp=i;
            int index=size-1;
            while(temp>0){
                int set=temp&1;
                temp=temp>>1;
                if(set==1){
                    subset.add(A[index]);
                }
                index--;
            }
            int sum=0;
            for(int j=0;j<subset.size();j++){
                sum+=subset.get(j);

            }
            if(sum==B){
                return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter number which u want to search");
        int B= sc.nextInt();
        int find=solve(A,B);
        System.out.println(find);

    }
}
