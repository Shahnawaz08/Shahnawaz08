package AdvanceDSA.BSTProblem;

import AdvanceDSA.BinaryTreeProblem.TreeNode;

import java.util.Scanner;
/*
Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Problem Constraints
1 <= length of array <= 100000
 */

public class P2_SortedArrayToBalancedBST {
    public static void preorderPrint(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.date);
        preorderPrint(root.left);
        preorderPrint(root.right);
    }
    public static TreeNode helperfun(int [] A,int s,int e){
        if(s>e){
            return null;
        }
        int mid=(s+e)/2;
        TreeNode root=new TreeNode(A[mid]);
        root.left=helperfun(A,s,mid-1);
        root.right=helperfun(A,mid+1,e);
        return root;
    }
    public static TreeNode sortedArrayToBST(final int[] A) {
        TreeNode root=helperfun(A,0,A.length-1);
        return root;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N= sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        TreeNode root=sortedArrayToBST(A);
        preorderPrint(root);

    }
}
