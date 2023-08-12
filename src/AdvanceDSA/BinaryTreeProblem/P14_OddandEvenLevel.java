package AdvanceDSA.BinaryTreeProblem;

import java.util.*;

public class P14_OddandEvenLevel {

    public static int solve(TreeNode A) {
        class pair{
            TreeNode root;
            int level;
            pair(TreeNode r,int d){
                root=r;
                level=d;
            }
        }
        Queue<pair> que=new LinkedList<>();
        pair temp=new pair(A,1);
        que.add(temp);
        long sum=0;
        long diff=0;
        while (!que.isEmpty()){
            pair t=que.poll();
            if(t.level%2==0){
                sum=sum-t.root.date;
            }else {
                sum=sum+t.root.date;
            }
            if(t.root.left!=null) {
                pair l=new pair(t.root.left,t.level+1);
                que.add(l);
            }
            if(t.root.right!=null){

                pair l=new pair(t.root.right,t.level+1);
                que.add(l);
            }
        }
        return (int)sum;

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
        int res=solve(root);

        System.out.println(res);
    }
}
