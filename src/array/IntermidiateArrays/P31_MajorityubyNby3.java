package array.IntermidiateArrays;
/*
You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times
in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.
 */

import java.util.Scanner;

public class P31_MajorityubyNby3 {
    public static int repeatedNumber(int[] A) {
        int maj1=-1;
        int maj2=-1;
        int freq1=0;
        int freq2=-1;
        for(int i=0;i<A.length;i++) {
            if (A[i] == maj1) {
                freq1++;
            } else if (A[i] == maj2) {
                freq2++;
            }
            else if (freq1==0) {
                maj1 = A[i];
                freq1++;
            } else if (freq2==0) {
                maj2 = A[i];
                freq2++;
            }
            else {
                freq1--;
                freq2--;
            }
        }
        System.out.println("freq1= "+freq1+" freq 2 "+freq2);
        freq1=0;
        freq2=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==maj1){
                freq1++;
            }
            if(A[i]==maj2){
                freq2++;
            }
        }
        if(freq1>A.length/3){
            return  maj1;
        }
        if(freq2>A.length/3){
            return  maj2;
        }
        return -1;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int majele=repeatedNumber(arr);
        System.out.println("Majority element is "+majele);

    }
}
