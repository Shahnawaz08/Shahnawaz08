package TreesProblem;

import java.util.ArrayList;
import java.util.Scanner;
/*
Given a binary search tree of integers. You are given a range B and C.
Return the count of the number of nodes that lie in the given range.
 */

public class P3_BST_nodes {
    public static void inorder(Node root,ArrayList arr) {
        if (root == null) {
            return;
        }

        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
    public static int solve(Node A, int B, int C) {
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(A,arr);
        int count=0;
        System.out.println(arr);
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)>=B && arr.get(i)<=C){
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args) {
        BinaryTree A=new BinaryTree();
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the range ");
        int B= sc.nextInt();
        int C= sc.nextInt();
        int noOfNode=solve(A.root,B,C);
        System.out.println(noOfNode);


    }
}
