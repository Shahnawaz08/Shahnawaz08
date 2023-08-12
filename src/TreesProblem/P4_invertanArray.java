package TreesProblem;

public class P4_invertanArray {
    public static Node invert(Node root){
        if(root==null){
            return null;
        }
        Node temp=root.right;
        root.right=root.left;
        root.left=temp;
        invert(root.left);
        invert(root.right);
        return root;

    }

    public static void main(String[] args) {
        BinaryTree B=new BinaryTree();
        B.inorderPrint(B.root);
        invert(B.root);
        B.inorderPrint(B.root);
    }
}
