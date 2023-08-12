package AdvanceDSA.BSTProblem;
/*
You are given a binary tree represented by root A.
Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.

Problem Constraints
1 <= Number of nodes in binary tree <= 105

0 <= node values <= 232-1
 */

import AdvanceDSA.BinaryTreeProblem.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;




public class P1_ValidBinarySearchTree {

    public static boolean validHelper(TreeNode A,long s,long e){
        if(A==null){
            return true;
        }
        System.out.println(A.date);
        System.out.println(A.date>s && A.date<e);
        return (A.date>s && A.date<e)&&validHelper(A.left,s,A.date)&&validHelper(A.right,A.date,e);
    }

    public static int isValidBST(TreeNode A) {
//        int s=Integer.MIN_VALUE;
//        int e=Integer.MAX_VALUE;
        long st=Long.MIN_VALUE;
        Long end=Long.MAX_VALUE;

        boolean isval=validHelper(A,st,end);
        int res=0;
        if(isval){
            res=1;
        }
        return res;

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
        int  isvalid=isValidBST(root);
        if(isvalid==1){
            System.out.println("Given BST is valid");
        }
        else {
            System.out.println("Given BST is not valid");
        }
    }
}
