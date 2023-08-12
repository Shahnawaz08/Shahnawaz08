package HashingProblems;

import java.util.*;

public class P23_ComapareSortedSubarray {
    //probablistic approach (sum of subarray will be same after replacing the element
    //with random element)
    public static int [] solve2(int [] A,int [][] B){
        HashMap<Integer,Long> map=new HashMap<>();
        Random random=new Random();
        for(int i=0;i<A.length;i++){
            if(!map.containsKey(A[i])){
                long x=random.nextLong();
                map.put(A[i],x);
            }
        }
        long[] prefixArray=new long[A.length];
        long prefixSum=0;
        for(int i=0;i<A.length;i++){
            prefixSum+=map.get(A[i]);
            prefixArray[i]=prefixSum;
        }
        int [] ans=new int[B.length];
        for(int i=0;i< ans.length;i++){
            int l1=B[i][0];
            int r1=B[i][1];
            int l2=B[i][2];
            int r2=B[i][3];
            long prefixsum1=0;
            if(l1==0){
                prefixsum1=prefixArray[r1];
            }else {
                prefixsum1=prefixArray[r1]-prefixArray[l1-1];
            }
            long prefixsum2=0;
            if(l2==0){
                prefixsum2=prefixArray[r2];
            }else {
                prefixsum2=prefixArray[r2]-prefixArray[l2-1];
            }
            if(prefixsum1==prefixsum2){
                ans[i]=1;
            }
            else {
                ans[i]=0;
            }

        }
        return ans;
    }


    public static int[] solve(int[] A, int[][] B) {//Giving TLe for hard Case
        int Q=B.length;
        int [] comp=new int[Q];
        for(int i=0;i<Q;i++){
            int s1=B[i][0];
            int l1=B[i][1];
            int s2=B[i][2];
            int l2=B[i][3];
            if(l1-s1!=l2-s2){
                comp[i]=0;


            }else {
                HashMap<Integer,Integer> hm=new HashMap<>();
                for(int j=s1;j<=l1;j++){
                    hm.put(A[j],hm.getOrDefault(A[j],0)+1);
                }
                int flag=1;
                for(int j=s2;j<=l2;j++){
                    if(!hm.containsKey(A[j])){
                        flag=0;
                        break;

                    }
                    else {
                        if(hm.get(A[j])==1){
                            hm.remove(A[j]);
                        }
                        else {
                            hm.put(A[j], hm.get(A[j])-1);
                        }
                    }
                }
                if(flag==0){
                    comp[i]=0;
                }
                else {
                    comp[i]=1;
                }
            }
        }

        return comp;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array");
        int N=sc.nextInt();
        int [] A=new int[N];
        for (int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        System.out.println("Enter number of queries");
        int M=sc.nextInt();
        int [][]B=new int[M][4];
        for(int i=0;i<M;i++){
            for(int j=0;j<4;j++){
                B[i][j]=sc.nextInt();
            }
        }
        int [] comArray=solve(A,B);
        System.out.println(Arrays.toString(comArray));

    }
}
