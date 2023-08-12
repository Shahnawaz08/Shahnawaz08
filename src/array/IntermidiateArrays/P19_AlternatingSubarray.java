package array.IntermidiateArrays;

import java.util.Arrays;
import java.util.Scanner;
/*
You are given an integer array A of length N comprising of 0's & 1's, and an integer B.
You have to tell all the indices of array A that can act as a center of 2 * B + 1 length 0-1 alternating subarray.
A 0-1 alternating array is an array containing only 0's & 1's, and having no adjacent 0's or 1's. For e.g. arrays
[0, 1, 0, 1], [1, 0] and [1] are 0-1 alternating, while [1, 1] and [0, 1, 0, 0, 1] are not.
 */

public class P19_AlternatingSubarray {
    public static int[] solve(int[] A, int B) {
        int N=A.length;
        int L=2*B+1;
        int [] res=new int[N];
        int index=0;
        int i,j;
        for(i=0;i<=N-L;i++){
            int state=1-A[i];
            for(j=i+1;j<i+L;j++){
                if(A[j]!=state){
                    break;
                }
                else{
                    state=1-state;
                }
            }
            if(j==i+L){
                res[index]=i+B;
                index++;
            }

        }
        int [] ans=new int[index];
        for(i=0;i<index;i++){
            ans[i]=res[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println("Enter size of subarray");
        int B = sc.nextInt();
        int[] s = solve(A, B);
        System.out.println(Arrays.toString(s));
    }
}
