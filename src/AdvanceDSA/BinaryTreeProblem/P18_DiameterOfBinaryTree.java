package AdvanceDSA.BinaryTreeProblem;

import java.util.ArrayList;
import java.util.Scanner;

public class P18_DiameterOfBinaryTree {
    static int maxdist=-1;
    public static int diameter(TreeNode A){
            if(A==null){
                return 0;
            }
            int leftdist=diameter(A.left);
            int rightdist=diameter(A.right);
            int dia=leftdist+rightdist;
            maxdist=Math.max(dia,maxdist);
            return Math.max(leftdist,rightdist)+1;
    }

    public static int solve(TreeNode A) {

        int dia=diameter(A);
        return dia;
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
        int n=solve(root);
        System.out.println(n);
        System.out.println("Diameter "+maxdist);

    }
}
