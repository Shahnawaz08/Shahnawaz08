package AdvanceDSA.BSTProblem;

import AdvanceDSA.BinaryTreeProblem.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P4_CommonNodesInTwoBST {
    static ArrayList<Integer> arr;

    public static void helperfn(TreeNode A){
        if(A==null) return;
        helperfn(A.left);
        arr.add(A.date);
        helperfn(A.right);


    }
    public static int solve(TreeNode A, TreeNode B) {
        arr=new ArrayList<>();
        helperfn(A);
        int []arr1=arr.stream().mapToInt(i->i).toArray();
        arr.clear();
        helperfn(B);
        int []arr2=arr.stream().mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        int i=0;
        int j=0;
        long sum= 0L;
        while (i<arr1.length&&j<arr2.length){
            if (arr1[i]<arr2[j]) i++;
            else if (arr1[i]>arr2[j]) j++;
            else {
                sum=(sum+arr1[i])%1000000007;
                i++;
                j++;
            }

        }
        return (int)sum;

    }
    public static TreeNode createTree(Scanner sc){
        int data= sc.nextInt();
        if(data==-1){
            return null;
        }
        TreeNode root=new TreeNode(data);
        root.left=createTree(sc);
        root.right=createTree(sc);
        return root;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode A=createTree(sc);
        System.out.println("Enter values of second Tree");
        TreeNode B=createTree(sc);
        int commonSum=solve(A,B);
        System.out.println("Sum of common data in two trees is "+commonSum);
        /*
        5
2 -1 3 -1 -1
8
-1 15 9 -1
-1 -1
Enter values of second Tree
7 1 -1 2 -1 -1
10 -1 15
11 -1
-1 -1
         */



    }
}
