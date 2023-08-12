package AdvanceDSA.BinaryTreeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class P4_PreOrderTraversal {
    public static int[] preorderTraversal(TreeNode A) {
        Stack<TreeNode> s=new Stack<>();
        ArrayList<Integer>arr=new ArrayList<>();
        s.add(A);
        TreeNode root=s.peek();
        while (!s.empty()){

            while (root!=null){
                arr.add(root.date);
                root=root.left;
                if(root!=null) {
                    s.add(root);
                }

            }
            TreeNode temp=s.pop();
            if(temp.right!=null) {
                root = temp.right;
                s.add(root);
            }

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
        int [] A=preorderTraversal(root);
        System.out.println(Arrays.toString(A));
    }
}
