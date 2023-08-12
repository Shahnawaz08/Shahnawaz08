package AdvanceDSA.BinaryTreeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P16_PrintPath {
    static ArrayList<Integer> arr;
    public static boolean path(TreeNode root,int key){
        //Base case
        if(root==null) return false;
        if(root.date==key) {
            arr.add(key);
//            System.out.println(root.date);
            return true;
        }
        //recursive course
        if(path(root.left,key)||path(root.right,key)){
            arr.add(root.date);
//            System.out.println(root.date);
            return true;
        }

        return false;
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
        TreeNode root=createTree(sc);
        System.out.println("Enter Nodes");
        int B=sc.nextInt();
        arr=new ArrayList<>();
        path(root,B);
        int [] fstroot=arr.stream().mapToInt(i->i).toArray();
        Arrays.sort(fstroot);
        System.out.println(Arrays.toString(fstroot));
    }
}
