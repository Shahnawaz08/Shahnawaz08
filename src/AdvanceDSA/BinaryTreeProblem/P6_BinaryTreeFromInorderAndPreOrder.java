package AdvanceDSA.BinaryTreeProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
Given preorder and inorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.



Problem Constraints
1 <= number of nodes <= 105
 */

public class P6_BinaryTreeFromInorderAndPreOrder {


        public static TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < inorder.length; i++) {

                inMap.put(inorder[i], i);
            }
            TreeNode root =buildTree(preorder, 0, preorder.length - 1, inorder, 0,
            inorder.length - 1, inMap);
            return root;

        }

        public static TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                                  int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
            if (preStart > preEnd || inStart > inEnd) return null;

            TreeNode root = new TreeNode(preorder[preStart]);
            int inRoot = inMap.get(root.date);
            int numsLeft = inRoot - inStart;
            root.left = buildTree(preorder, preStart + 1, preStart + numsLeft,

                    inorder, inStart, inRoot - 1, inMap);
            root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd,
                    inorder, inRoot + 1, inEnd, inMap);
            return root;

        }
        static void preOrder(TreeNode node)
        {
            if (node == null)
                return;
            System.out.print(node.date + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter size of array");
            int N = sc.nextInt();
            int[] A = new int[N];
            System.out.println("Enter element in preorder traversal");
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            int[] B = new int[N];
            System.out.println("Enter element in inorder traversal");
            for (int i = 0; i < N; i++) {
                B[i] = sc.nextInt();
            }
            TreeNode root = buildTree(A, B);
            preOrder(root);

        }
    }
