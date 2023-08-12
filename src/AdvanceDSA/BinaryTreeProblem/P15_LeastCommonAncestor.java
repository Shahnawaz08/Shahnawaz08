package AdvanceDSA.BinaryTreeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P15_LeastCommonAncestor {
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
    public static int lca(TreeNode A, int B, int C) {
      arr=new ArrayList<>();
      boolean pres=path(A,B);
      if(!pres) return -1;
      int [] fstroot=arr.stream().mapToInt(i->i).toArray();
//      Arrays.re(fstroot);
      arr.clear();
      boolean pres2=path(A,C);
      if(!pres2) return -1;
      int [] secroot=arr.stream().mapToInt(i->i).toArray();
  //    Arrays.sort(secroot);
        System.out.println(Arrays.toString(fstroot));
        System.out.println(Arrays.toString(secroot));
        int i=fstroot.length-1;
        int j=secroot.length-1;
        while (fstroot[i]!=secroot[j]){
            i--;
            j--;
        }
        return fstroot[i];
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
        int C=sc.nextInt();
        int res=lca(root,B,C);
        System.out.println(res);
    }
}
