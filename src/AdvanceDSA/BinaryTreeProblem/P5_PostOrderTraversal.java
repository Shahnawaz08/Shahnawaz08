package AdvanceDSA.BinaryTreeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
/*
Given a binary tree, return the Postorder traversal of its nodes values.

NOTE: Using recursion is not allowed.



Problem Constraints
1 <= number of nodes <= 105
 */
public class P5_PostOrderTraversal {
    /*
    Here we are storing the node in first stack and then pop the top and push to second stack also push the left and
    right to the first stack and then repeat the steps till first stack is not empty
     */
    public static int[] postorderTraversal(TreeNode A) {
        Stack<TreeNode> tempStack=new Stack<>();
        Stack<TreeNode> finalStack=new Stack<>();
        tempStack.add(A);
        while (!tempStack.isEmpty()){
            TreeNode temp=tempStack.pop();
            finalStack.add(temp);
            if(temp.left!=null){
               tempStack.add(temp.left);
            }
            if(temp.right!=null){
                tempStack.add(temp.right);
            }

        }
        int [] arr=new int[finalStack.size()];
        int i=0;
        while (!finalStack.isEmpty()){
            arr[i]=finalStack.pop().date;
            i++;
        }
        return arr;
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
        //Node tree=new Node(5);
        //System.out.println(tree.date);
        TreeNode root=createTree(sc);
        int [] A=postorderTraversal(root);
        System.out.println(Arrays.toString(A));
    }
}
