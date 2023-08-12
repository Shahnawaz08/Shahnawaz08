package SubsequanceAndSubset;

import java.util.Scanner;

public class P9_oddevensubsequance {
    public static int solve(int[] A) {
        int len=A.length;
        int flag=-1;
        int cnt=0;
        if(A[0]%2==0){
            flag=1;
            cnt++;
        }
        else{
            flag=0;
            cnt++;
        }
        for(int i=1;i<len;i++){
            if(A[i]%2==0 && flag==0){
                cnt++;
                flag=1-flag;
            }
            else if(A[i]%2!=0 && flag==1){
                cnt++;
                flag=1-flag;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int lenofSubseq=solve(A);
        System.out.println(lenofSubseq);


    }
}
