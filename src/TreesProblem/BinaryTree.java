package TreesProblem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        data=d;
        left=right=null;
    }
}

public class BinaryTree {
    Node root;
    BinaryTree(){
        //read & create tree as well
        Scanner sc=new Scanner(System.in);
        root=buildTree(sc);
    }
    Node buildTree(Scanner sc){
        //read data
        int data =sc.nextInt();
        //base case
        if(data==-1){
            return null;
        }
        //Rec case
        Node n=new Node(data);
        n.left=buildTree(sc);
        n.right=buildTree(sc);
        return n;
    }
    void print(){
        preorderPrint(root);
    }
//    helper fn for recursive printing
    void preorderPrint(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preorderPrint(root.left);
        preorderPrint(root.right);
    }
    void printpost(){
        postorderPrint(root);
    }
    //    helper fn for recursive printing
    void postorderPrint(Node root) {
        if (root == null) {
            return;
        }
        preorderPrint(root.left);
        System.out.println(root.data);
        preorderPrint(root.right);
    }
    void printinorder(){
        inorderPrint(root);
    }
    //    helper fn for recursive printing
    void inorderPrint(Node root) {
        if (root == null) {
            return;
        }
        preorderPrint(root.left);
        System.out.println(root.data);
        preorderPrint(root.right);
    }
    public int preorderComp(Node A,Node B) {
        Stack < Node > stack1 = new Stack < > ();
        Stack < Node > stack2 = new Stack < > ();
        if (A == null && B==null)
            return 1;
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

    public int[] preorderTraversal() {
        Node A=root;
        ArrayList < Integer > res = new ArrayList < Integer > ();
        Stack < Node > stack = new Stack < > ();
        int [] a=new int [0];
        if (A == null)

            return a;
        stack.push(A);
        Node node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            res.add(node.data);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        int [] arr = new int[res.size()];

        // ArrayList to Array Conversion
        for (int i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
    public void postorderTraversal() {
        Node A=root;
        ArrayList < Integer > res = new ArrayList < Integer > ();
        Stack < Node > stack = new Stack < > ();
        int [] a=new int [0];
        if (A == null)
            return ;
        stack.push(A);
        Node node;
        while (!stack.isEmpty()) {
            node = stack.peek();
            if (node.right != null) {
                stack.push(node.right);
                continue;
            }
            if (node.left != null) {
                stack.push(node.left);
                continue;
            }


        }
        System.out.println(stack);
        int [] arr = new int[res.size()];

        // ArrayList to Array Conversion
        for (int i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return;
    }
}
