package array.IntermidiateArrays;
import java.util.Scanner;
/*
Given a char array ,calculate the number of pairs of (i,j)
such that i<j and arr[i]=='a' and arr[j]=='g'
 All character are in lower case
 */

public class P25_CarryForward {
    public static  void noOfPairsM1(char[] A){
        int ans=0;
        int count=0;
        for(int i=0;i<A.length;i++){
            if(A[i]=='a'){
                count++;
            }
            else if(A[i]=='g'){
                ans+=count;
            }
        }
        System.out.println("No of pairs of a and g "+ans);

    }
    public static  void noOfPairsM2(char[] A){
        int ans=0;
        int count=0;
        for(int i=A.length-1;i>=0;i--){
            if(A[i]=='a'){
                ans+=count;
            }
            else if(A[i]=='g'){
                count++;
            }
        }
        System.out.println("No of pairs of a and g "+ans);

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N=sc.nextInt();
        char [] A=new char[N];
        for(int i=0;i<N;i++){
            A[i]= sc.next().charAt(0);
        }
//        for(int i=0;i<N;i++){
//            System.out.println(A[i]);
//        }
        noOfPairsM1(A);
        noOfPairsM2(A);
    }
}
