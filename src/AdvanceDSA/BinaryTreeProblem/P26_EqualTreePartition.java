package AdvanceDSA.BinaryTreeProblem;
/*
Given a binary tree A. Check whether it is possible to partition the tree to
two trees which have equal sum of values after removing exactly one edge on the
original tree.

Problem Constraints
1 <= size of tree <= 100000

0 <= value of node <= 109
 */

import java.util.HashSet;
import java.util.Scanner;

public class P26_EqualTreePartition {
    static HashSet<Long> hm;

    public static long sum(TreeNode A){
        if(A==null) return 0;
        long lsum=sum(A.left);//sum the left subtree
        long rsum=sum(A.right);// sum the Right subtree
        long  nodedata=A.date;
        long totalsum=lsum+rsum+nodedata;
        hm.add(totalsum);
        return totalsum;
    }

    public static int solve(TreeNode A) {
        hm=new HashSet<>();
        long tsum=sum(A);
        //System.out.println("total sum"+tsum);
        //System.out.println(hm);
        if(hm.contains(tsum/2)){
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
        int isqual=solve(root);
        System.out.println(isqual);





    }
}
