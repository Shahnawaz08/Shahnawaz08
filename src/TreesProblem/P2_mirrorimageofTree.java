package TreesProblem;

import java.util.Stack;

public class P2_mirrorimageofTree {
    public static void inorderPrint(Node root) {
        if (root == null) {
            return;
        }

        inorderPrint(root.left);
        System.out.println(root.data );
        inorderPrint(root.right);
    }
    public static Node copyNodes(Node root) {
        if (root == null) {
            return null;
        }
        Node B=new Node(root.data);
        B.left=copyNodes(root.left);
        B.right=copyNodes(root.right);
        //System.out.println(root.data );


        return B;
    }

    public static void invert(Node root){
        if(root==null){
            return;
        }
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
        invert(root.left);
        invert(root.right);
        return;

    }
    public static int preorderComp(Node A,Node B) {
        Stack< Node > stack1 = new Stack < > ();
        Stack < Node > stack2 = new Stack < > ();
        if (A == null && B==null) {
            return 1;
        }
        stack1.push(A);
        stack2.push(B);
        Node node1;
        Node node2;
        while (!stack1.isEmpty()) {
            node1 = stack1.pop();
            if(stack2.isEmpty()){
                return 0;
            }
            node2 = stack2.pop();
            System.out.println("A data "+node1.data +" B data "+node2.data);
            if(node1.data!=node2.data){
                return 0;
            }
            if (node1.right != null)
                stack1.push(node1.right);
            if (node1.left != null)
                stack1.push(node1.left);
            if (node2.right != null)
                stack2.push(node2.right);
            if (node2.left != null)
                stack2.push(node2.left);
        }
        if(!stack2.isEmpty()){
            return 0;
        }
        return 1;
    }
    public static boolean comp(Node A,Node B){
        if(A==null && B==null){
            return true;
        }
        if(A==null ||B==null){
            return false;
        }
        if(A.data==B.data && comp(A.left,B.left) && comp(A.right,B.right)){
            return true;
        }
        return false;

    }



    public static void main(String[] args) {
        BinaryTree A=new BinaryTree();
        inorderPrint(A.root);
        System.out.println();
       Node B=copyNodes(A.root);
       invert(B);
        inorderPrint(A.root);
        System.out.println();

        inorderPrint(B);
        int n=preorderComp(A.root,B);
        System.out.println(n);
        /*
        boolean n=comp(A.root,B);
        if(n){
            System.out.println("symmetric");
        }
        else {
            System.out.println("not symmetric ");
        }

         */



    }
}
