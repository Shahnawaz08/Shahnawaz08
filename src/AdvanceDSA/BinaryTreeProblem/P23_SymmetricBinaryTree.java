package AdvanceDSA.BinaryTreeProblem;

import java.util.*;
/*
Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).



Problem Constraints
1 <= number of nodes <= 105
 */

public class P23_SymmetricBinaryTree {
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
    public static boolean helperfn(TreeNode left,TreeNode right){
        if(left==null||right==null){
            return left==right;
        }
        if(left.date!=right.date) return false;
        return helperfn(left.left,right.right)&&helperfn(left.right,right.left);

    }


    public static int isSymmetric(TreeNode A) {
        if(A==null) return 1;
        boolean issem=helperfn(A.left,A.right);
        if(issem) return 1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode root=createTree(sc);
        int issem=isSymmetric(root);
        System.out.println(issem);





    }
}
