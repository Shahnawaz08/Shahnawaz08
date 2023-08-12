package AdvanceDSA.BinaryTreeProblem;
/*
Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.

Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.

An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

Return 1 if it sum-binary tree else return 0.



Problem Constraints
1 <= length of the array <= 100000

0 <= node values <= 50
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class P22_SumBinaryTree {
    static boolean sbt;
    public static int solve(TreeNode A) {
        if(A==null){
            return 0;
        }
        if(A.right==null&&A.left==null){
            return A.date;
        }
        int subsum=solve(A.left)+solve(A.right);
        if(subsum!=A.date){
            sbt=false;
            return subsum;

        }
        return subsum*2;
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
        TreeNode root=createTree(sc);
        sbt=true;
        int issumbt=solve(root);
        if(sbt){
            System.out.println("Given binary tree is sum binary tree");
        }
        else {
            System.out.println("Given binary tree is not sum binary tree");
        }


    }
}
