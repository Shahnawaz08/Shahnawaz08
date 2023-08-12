package AdvanceDSA.BinaryTreeProblem;

import java.util.*;
/*
Given a root of binary tree A, determine if it is height-balanced.

A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Problem Constraints
1 <= size of tree <= 100000
 */

public class P8_TopViewOfBinaryTree {
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
//                if(prev!=A) arr.add(prev.date);
                if(!que.isEmpty()){

                    que.add(null);
                    prev=null;
                }
            }
            else {
                if(prev==null){
                    arr.add(current.date);
                }
               // if(current.left!=null) que.add(current.left);
                if(current.right!=null) que.add(current.right);
                prev=current;
            }
        }
        if(A!=null&&A.right!=null)  {
            que.add(A.right);
            que.add(null);
        }
        prev=null;
        while (!que.isEmpty()){
            TreeNode current=que.poll();
            if(current==null){
//                if(prev!=A) arr.add(prev.date);
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
                //if(current.left!=null) que.add(current.left);

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
        System.out.println("Top viewws of the binary tree "+ Arrays.toString(topview));

    }
}
