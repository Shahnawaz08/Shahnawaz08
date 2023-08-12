package AdvanceDSA.BinaryTreeProblem;

import java.util.Scanner;
/*
Given two binary trees, check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.


Problem Constraints
1 <= number of nodes <= 105
 */

public class P25_IdenticalBinaryTree {
    public static int isSameTree(TreeNode A, TreeNode B) {
        if(A==null||B==null){
            if(A==B) return 1;
            return 0;
        }
        if(A.date!=B.date) return 0;
        return isSameTree(A.left,B.left)*isSameTree(A.right,B.right);
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
        TreeNode B=createTree(sc);
        int isqu=isSameTree(A,B);
        if(isqu==1){
            System.out.println("This two binary trees are equal");
        }
        else {
            System.out.println("This two binary tree are not equal");
        }






    }
}
