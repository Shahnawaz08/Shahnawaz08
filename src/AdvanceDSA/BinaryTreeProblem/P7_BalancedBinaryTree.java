package AdvanceDSA.BinaryTreeProblem;

import java.util.Arrays;
import java.util.Scanner;

/*
Given a root of binary tree A, determine if it is height-balanced.

A height-balanced binary tree is defined as a binary tree in which
the depth of the two subtrees of every node never differ by more than
1.

Problem Constraints
1 <= size of tree <= 100000
 */
class pair{
    boolean balanced;
    int height;
}

public class P7_BalancedBinaryTree {
    public static pair helperfn(TreeNode A){
        pair p=new pair();
        if(A==null){
            p.height=0;
            p.balanced=true;
            return p;
        }
        pair left=helperfn(A.left);
        pair right=helperfn(A.right);
        int hightdiff=Math.abs((left.height-right.height));
        p.height=Math.max(left.height,right.height)+1;
        p.balanced=hightdiff<=1&&left.balanced&&right.balanced;
        return p;

    }
    public static int isBalanced(TreeNode A) {
        pair bal=helperfn(A);
        int isbalance=0;
        if(bal.balanced){
            isbalance=1;
        }
        return isbalance;
    }
    static int balanced=1;
    public static int isBalancedsec(TreeNode A) {
        if(A==null){
            return -1;
        }
        int left=isBalanced(A.left);
        int right=isBalanced(A.right);
        if(Math.abs(left-right)>1){
            balanced=0;
        }
        return Math.max(left,right)+1;
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
        //Node tree=new Node(5);
        //System.out.println(tree.date);
        TreeNode root=createTree(sc);
        int isbal=isBalanced(root);
        if(isbal==1)
         System.out.println("Tress is balanced binary tree");
        else
            System.out.println("Tree is not balanced binary tree");
        isbal=isBalancedsec(root);
        if(isbal==1)
            System.out.println("Tress is balanced binary tree");
        else
            System.out.println("Tree is not balanced binary tree");
    }
}
