package AdvanceDSA.BinaryTreeProblem;
/*

Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
NOTE: The value comes first in the array which have lower level.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 109
 */

import java.util.*;

public class P12_LeftViewOfBinaryTree {
    public static int[] solve(TreeNode A) {
        Queue<TreeNode> que=new LinkedList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        if(A!=null){
            que.add(A);
            que.add(null);
        }
        TreeNode prev=null;
        while (!que.isEmpty()){
            TreeNode curr=que.poll();
            if(curr==null){
                if(!que.isEmpty()) que.add(null);
            }
            else {
                if(prev==null)arr.add(curr.date);
                if(curr.left!=null) que.add(curr.left);
                if(curr.right!=null) que.add(curr.right);

            }
            prev=curr;
        }
        return arr.stream().mapToInt(j->j).toArray();

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
        System.out.println("left view  of the binary tree "+ Arrays.toString(topview));

    }
}
