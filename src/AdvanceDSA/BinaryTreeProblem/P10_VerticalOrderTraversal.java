package AdvanceDSA.BinaryTreeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class P10_VerticalOrderTraversal {
    static HashMap<Integer,ArrayList<Integer>> hm;
    public static void VOT(TreeNode A,int dist){
        if(A==null) return;
        ArrayList<Integer> temp=hm.getOrDefault(dist, new ArrayList<>());
        temp.add(A.date);
        hm.put(dist,temp);
        VOT(A.left,dist-1);
        VOT(A.right,dist+1);
    }
    public static  int[][] verticalOrderTraversal(TreeNode A) {
        VOT(A,0);
        //System.out.println(hm);
        int minidx=Integer.MAX_VALUE;
        int maxidx=Integer.MIN_VALUE;
        for(int k:hm.keySet()){
            if(k<minidx){
                minidx=k;
            }
            if(k>maxidx){
                maxidx=k;
            }
        }
        System.out.println(hm);
        int noOfRows=maxidx-minidx+1;
        System.out.println("max"+maxidx+" min "+minidx+" no of rows "+noOfRows);
        int [][]arr=new int[noOfRows][];
        for(int i=0;i<noOfRows;i++){
            ArrayList<Integer> temp=hm.get(minidx);
            int []temparr=hm.get(minidx).stream().mapToInt(j->j).toArray();
            Arrays.sort(temparr);
            arr[i]=temparr;
            minidx++;
        }
        return arr;
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
        hm=new HashMap<>();
        int [][] vorder=verticalOrderTraversal(root);
        System.out.println("vertical order "+Arrays.deepToString(vorder));
    }
}
