package AdvanceDSA.BinaryTreeProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeLinkNode {
     int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }
public class P20_NextPointerBinaryTree {
    static Queue<TreeLinkNode> que;
    public static void connect(TreeLinkNode root) {
        if(root!=null){
            que.add(root);
            que.add(null);
            TreeLinkNode prev=null;
            while (!que.isEmpty()){
                TreeLinkNode curr=que.poll();
                if(curr==null){
                    if(!que.isEmpty()){
                        que.add(null);
                    }
                }
                else {
                   curr.next=prev;
                   if(curr.right!=null) que.add(curr.right);
                   if(curr.left!=null) que.add(curr.left);
                }
                prev=curr;
            }
        }
    }

        public static TreeLinkNode createTree(Scanner sc){
        int data= sc.nextInt();
        if(data==-1){
            return null;
        }
        TreeLinkNode root=new TreeLinkNode(data);
        root.left=createTree(sc);
        root.right=createTree(sc);
        return root;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeLinkNode root=createTree(sc);
        que=new LinkedList<>();
        connect(root);


    }
}
