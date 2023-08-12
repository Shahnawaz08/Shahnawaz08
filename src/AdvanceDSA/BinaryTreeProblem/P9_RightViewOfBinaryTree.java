package AdvanceDSA.BinaryTreeProblem;
/*
Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.

Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9
 */

import java.util.*;

public class P9_RightViewOfBinaryTree {
    public static int[] solve(TreeNode A) {

        Queue<TreeNode> que=new LinkedList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        if(A!=null){
            que.add(A);
            que.add(null);
        }
        TreeNode prev=null;
        while (!que.isEmpty()){
            TreeNode current=que.poll();
            if(current==null){
                if(!que.isEmpty()){

                    que.add(null);
                    prev=null;
                }
            }
            else {
                if(prev==null){
                    arr.add(current.date);
                }

                if(current.right!=null) que.add(current.right);
                if(current.left!=null) que.add(current.left);
                prev=current;
            }
        }
        return arr.stream().mapToInt(i->i).toArray();
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
        int [] topview=solve(root);
        System.out.println("Right view  of the binary tree "+ Arrays.toString(topview));

    }
}
