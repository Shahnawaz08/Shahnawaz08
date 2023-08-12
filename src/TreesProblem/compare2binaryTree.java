package TreesProblem;

public class compare2binaryTree {
    public static void main(String[] args) {
        BinaryTree n=new BinaryTree();
        System.out.println("input 2nd ");
        BinaryTree n2=new BinaryTree();
        int x=n.preorderComp(n.root,n2.root);
        System.out.println(x);

    }
}
