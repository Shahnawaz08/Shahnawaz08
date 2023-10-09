package AdvanceDSA.BSTProblem;
/*
Problem Description
Two elements of a Binary Search Tree (BST), represented by root A are swapped by mistake. Tell us the 2 values, when swapped, will restore the Binary Search Tree (BST).

A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?

Note: The 2 values must be returned in ascending order



Problem Constraints
1 <= size of tree <= 100000
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P5_RecoverBST {


    //Creating a node class
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
    }
    public static int[] recoverTree(TreeNode A) {
        int [] arr=new int[2];
        ArrayList<Integer> preOrder= new ArrayList<Integer>();
        givepreorder(A,preOrder);
        //System.out.println(preOrder);
        int prev=0;
        int next;
        for(int i=1;i<preOrder.size();i++){
            next=i;
            if(preOrder.get(prev)>preOrder.get(next)){
                int min=preOrder.get(next);
                for(int j=next+1; j<preOrder.size();j++){

                    min=Math.min(min,preOrder.get(j));
                }
//                while (prev>=0 && preOrder.get(prev)>preOrder.get(next) ){
//                    prev--;
//                }
                arr[1]=preOrder.get(prev);
                arr[0]=min;
                break;
            }
            prev=next;
        }

        return arr;
    }

    //create a Tree
    public static TreeNode createTree(Scanner sc){
        TreeNode root= new TreeNode();
        int data=sc.nextInt();
        if(data==-1){
            root=null;
            return root;
        }
        root.data=data;
        root.left=createTree(sc);
        root.right=createTree(sc);
        return root;
    }

    //print tree in preorder traversal
    public static  void printpreorder(TreeNode root){
        if(root==null){
            return;
        }
        printpreorder(root.left);
        System.out.println(root.data);
        printpreorder(root.right);

    }

    //Save element of tree in preorder traversal
    public static  void givepreorder(TreeNode root, ArrayList<Integer> al){
        if(root==null){
            return;
        }
        givepreorder(root.left,al);
        al.add(root.data);
        givepreorder(root.right,al);

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode root=createTree(sc);
        //printpreorder(root);
        int [] arr=recoverTree(root);
        System.out.println("toggled element sis "+ Arrays.toString(arr));

    }

}
