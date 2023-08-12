package AdvanceDSA.BinaryTreeProblem;
/*
You are given an integer array A denoting the Level Order Traversal of the Binary Tree.

You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.

NOTE:

In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.


Problem Constraints
1 <= number of nodes <= 105

-1 <= A[i] <= 105
 */

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P27_DeserializeBinaryTree {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }
  public static void printPreorder(TreeNode root){
        if(root==null) return;
      System.out.print(root.val +" ");
      printPreorder(root.left);
      printPreorder(root.right);
  }
    public static TreeNode solve(int[] A) {
        int N=A.length;
        TreeNode root=new TreeNode(A[0]);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int i=1;
        while (!q.isEmpty()){
            TreeNode temp=q.poll();
            TreeNode left=null;
            TreeNode right=null;
            if(i<N ) {
                if(A[i]!=-1){
                     left=new TreeNode(A[i]);
                     q.add(left);
                }
                i++;
            }
            if(i<N ) {
                if(A[i]!=-1){
                    right=new TreeNode(A[i]);
                    q.add(right);
                }
                i++;
            }
            temp.left=left;
            temp.right=right;

        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of an array");
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        TreeNode root=solve(A);
        printPreorder(root);
    }
}
