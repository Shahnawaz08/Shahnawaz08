package AdvanceDSA.BinaryTreeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P19_PathToLeafFromRoot {
    static ArrayList<Integer> arr;
    public static void solve(TreeNode A){
        if(A==null) return;
        if(A.left==null&&A.right==null){//if node is leaf then add that node and print it
            arr.add(A.date);
            System.out.println(arr);
            int indexlst=arr.size()-1;
            arr.remove(indexlst);//remove the added leaf node since it have no use
        }
        arr.add(A.date);
        solve(A.left);
        solve(A.right);
        int indexlst=arr.size()-1;
        arr.remove(indexlst);//after traversing left and right of a node remove it from arraylist
        //since all path we have printed from that node

    }
    static ArrayList<ArrayList<Integer>> twoDarr;
    public static void solveaddtoarray(TreeNode A){
        if(A==null) return;
        if(A.left==null&&A.right==null){//if node is leaf then add that node and print it
            ArrayList<Integer> AL2 = new ArrayList<>(List.copyOf(arr));
            AL2.add(A.date);
            System.out.println(AL2);
            twoDarr.add(AL2);

        }
        arr.add(A.date);
        solveaddtoarray(A.left);
        solveaddtoarray(A.right);
        int indexlst=arr.size()-1;
        arr.remove(indexlst);//after traversing left and right of a node remove it from arraylist
        //since all path we have printed from that node

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
        arr=new ArrayList<>();
        twoDarr=new ArrayList<>();
        solveaddtoarray(root);
        System.out.println(twoDarr);


    }
}
