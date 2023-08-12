package AdvanceDSA.BinaryTreeProblem;
/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.



Problem Constraints
1 <= number of nodes <= 105

-100000 <= B, value of nodes <= 100000
 */

import java.util.Scanner;

public class P24_PathSum {
    static  int k;
    public static boolean helperfn(TreeNode A,int sum){
        if(A==null) return false;
        if(A.left==null&&A.right==null) {
            sum=sum+A.date;
            if(sum==k) return true;
        }
        sum=sum+A.date;
        return helperfn(A.left,sum)||helperfn(A.right,sum);
    }

    public static int hasPathSum(TreeNode A, int B) {
        k=B;
        boolean is=helperfn(A,0);
        if(is){
            return 1;
        }
        return 0;

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
        int B=sc.nextInt();
        int issem=hasPathSum(root,B);
        System.out.println(issem);





    }
}
