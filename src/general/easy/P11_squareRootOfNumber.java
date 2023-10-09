package general.easy;

import java.util.Scanner;

/*
Problem Description
Given an integer A. Compute and return the square root of A.
If A is not a perfect square, return floor(sqrt(A)).

The value of A can cross the range of Integer.

NOTE:
   Do not use the sqrt function from the standard library.
   Users are expected to solve this in O(log(A)) time.


Problem Constraints
0 <= A <= 1010


Input Format
The first and only argument given is the integer A.


Output Format
Return floor(sqrt(A))


Example Input
Input 1:

 11
Input 2:

 9


Example Output
Output 1:

 3
Output 2:

 3


Example Explanation
Explanation 1:
When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
 */
public class P11_squareRootOfNumber {
    public static int sqrt(int A) {
        if(A==0||A==1){
            return A;
        }
        int ans = 0;
        int l=1;
        int r=A;
        while(l<=r){
            System.out.println(l+" "+r);
            int mid=(r-l)/2+l;
            int num=A/mid;
            if(num==mid &&(A % mid == 0)){
                ans=mid;
                break;
            }
            else if(num<mid){
                r=mid-1;
            }
            else {
                ans=mid;
                l=mid+1;
            }
        }
        return ans;


    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int sqroot=sqrt(A);
        System.out.println("square root of a number is "+sqroot);
    }
}
