package AdvanceDSA.BSTProblem;

import AdvanceDSA.BinaryTreeProblem.TreeNode;

import java.util.ArrayList;
import java.util.Scanner;

public class P3_KthSmallestInBST {
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
    static ArrayList<Integer> arr;

    public static void helperfn(TreeNode A){
        if(A==null) return;
        helperfn(A.left);
        arr.add(A.date);
        helperfn(A.right);


    }
    public static int kthsmallest(TreeNode A, int B) {
        arr=new ArrayList<>();
        helperfn(A);
        if(B<=arr.size()){
            return arr.get(B-1);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode root=createTree(sc);
        int B=sc.nextInt();
        int kthSmNO=kthsmallest(root,B);
        System.out.println("Kth Smallest number is "+kthSmNO);


    }
}
