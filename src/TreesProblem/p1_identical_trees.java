package TreesProblem;

public class p1_identical_trees {
    public static boolean isSameTree(Node A, Node B) {
        if(A==null && B==null){ return true;}
        if(A ==null || B==null){return  false;}
        if(A.data==B.data && isSameTree(A.left,B.left) && isSameTree(A.right,B.right)){
            return true;

        }

        return false;
    }
    public static void main(String[] args) {
        BinaryTree A=new BinaryTree();
        System.out.println("Enter another tree");
        BinaryTree B=new BinaryTree();
        //B.printpost();
        boolean isSame=isSameTree(A.root,B.root);
        System.out.println(isSame);
    }
}
