package AdvanceDSA.BinaryTreeProblem;

import java.util.*;

public class P2_levelorder {
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
    public static int[][] levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        Queue<TreeNode> que=new LinkedList<>();
        if(A!=null){
            que.add(A);
            que.add(null);
        }
        ArrayList<Integer> rowarraylist=new ArrayList<>();
        while (!que.isEmpty()){
            if(que.peek()==null){
                que.poll();

                ArrayList<Integer> temp=new ArrayList<>(rowarraylist);//this way of copy craete new array list
                //temp=rowlist------in this condition both are referring to same object
                arr.add(temp);
                rowarraylist.clear();
                if(!que.isEmpty()){
                    que.add(null);
                }

            }
            else {
                TreeNode root=que.poll();
                rowarraylist.add(root.date);
                if(root.left!=null){
                    que.add(root.left);
                }
                if(root.right!=null){
                    que.add(root.right);
                }
            }
        }
        //System.out.println(arr);
        int [][]res=new int[arr.size()][];int i=0;
        for(ArrayList<Integer> r:arr){
            int [] tmp=new int[r.size()];

            for (int j=0;j<r.size();j++){
                tmp[j]=r.get(j);
            }
            res[i]=tmp;
            i++;


        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode root=createTree(sc);
        int [][]res=levelOrder(root);
        System.out.println("level order of tree is ");
        System.out.println(Arrays.deepToString(res));
    }
}
