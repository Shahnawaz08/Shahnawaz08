package AdvanceDSA.BinaryTreeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class P1_InorderTraversal {


    public static int[] inorderTraversal(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();
        if (root == null)
            return arr.stream().mapToInt(i->i).toArray();


        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;

        // traverse the tree
        while (curr != null || s.size() > 0) {

            /* Reach the left most Node of the
            curr Node */
            while (curr != null) {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
                s.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = s.pop();

            //System.out.print(curr.date + " ");
            arr.add(curr.date);

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
            curr = curr.right;
        }
        return arr.stream().mapToInt(i->i).toArray();
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
        int [] A=inorderTraversal(root);
        System.out.println(Arrays.toString(A));
    }
}
