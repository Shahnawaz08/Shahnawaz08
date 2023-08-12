package AdvanceDSA.BinaryTreeProblem;

import java.util.Scanner;
/*
Given the inorder and postorder traversal of a tree, construct the binary tree.
NOTE: You may assume that duplicates do not exist in the tree.

Problem Constraints
1 <= number of nodes <= 105
 */

public class P3_BinaryTreeFromInorderandPostOrder {
    static void preOrder(TreeNode node)
    {
        if (node == null)
            return;
        System.out.print(node.date + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    static TreeNode buildUtil(int in[], int post[], int inStrt,
                   int inEnd, int postStrt, int postEnd)
    {
        // Base case
        if (inStrt > inEnd)
            return null;

        /* Pick current node from Postorder traversal using
           postIndex and decrement postIndex */
        TreeNode node = new TreeNode(post[postEnd]);

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return node;
        int iIndex = search(in, inStrt, inEnd, node.date);

        /* Using index in Inorder traversal, construct left
           and right subtrees */
        node.left = buildUtil(
                in, post, inStrt, iIndex - 1, postStrt,
                postStrt - inStrt + iIndex - 1);
        node.right = buildUtil(in, post, iIndex + 1, inEnd,
                postEnd - inEnd + iIndex,
                postEnd - 1);

        return node;
    }
    static int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                break;
        }
        return i;
    }
    public static TreeNode buildTree(int[] A, int[] B) {
        int N=A.length;
        TreeNode root =buildUtil(A,B,0,N-1,0,N-1);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        int N=sc.nextInt();
        int []A=new int[N];
        System.out.println("Enter element in inorder traversal");
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int []B=new int[N];
        System.out.println("Enter element in postorder traversal");
        for(int i=0;i<N;i++) {
            B[i] = sc.nextInt();
        }
        TreeNode root=buildTree(A,B);
        preOrder(root);

    }
}
