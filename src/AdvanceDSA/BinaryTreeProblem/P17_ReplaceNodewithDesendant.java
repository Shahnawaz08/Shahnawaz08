package AdvanceDSA.BinaryTreeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P17_ReplaceNodewithDesendant {
    static void preOrder(TreeNode node)
    {
        if (node == null)
            return;
        System.out.print(node.date + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static int helperfn(TreeNode root){
        if(root.left==null&&root.right==null){
            return root.date;
        }
        if(root==null){
            return 0;
        }
        int x=root.date;
        root.date=helperfn(root.left)+helperfn(root.right);
        return x+root.date;
    }
    public static TreeNode solve(TreeNode root){
        int rootd=helperfn(root);
        return root;
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
        root=solve(root);
        preOrder(root);
    }
}
