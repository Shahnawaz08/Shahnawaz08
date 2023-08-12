package AdvanceDSA.StacksProblems;

import java.util.*;

public class P10_AllSubarray {
    public static int solve(int [] arr){
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();
        int res = 0, l = 0, i;

        // Traversing given array
        for (i = 0; i < n; i++) {

            // If there are elements in stack
            // and top of stack is less than
            // current element then pop the elements
            while (!stack.isEmpty() &&
                    stack.get(stack.size()-1) < arr[i]) {
                stack.remove(stack.size()-1);
                l--;
            }

            // Push current element
            stack.add(arr[i]);

            // Increasing length of stack
            l++;
            if (l > 1) {

                // Updating the maximum result
                res = Math.max(res,
                        stack.get(l - 1) ^ stack.get(l - 2));
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int sum=solve(A);
        System.out.println("Sum of all the values "+sum);
    }
}
