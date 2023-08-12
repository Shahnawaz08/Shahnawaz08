package AdvanceDSA.BinaryTreeProblem;

import java.lang.reflect.Array;
import java.util.*;

public class P11_verticalOrderTraversal {
    static HashMap<Integer, ArrayList<Integer>> hm;
    public static int[][] verticalOrderTraversal(TreeNode A) {
        class pair{
            TreeNode root;
            int dist;
            pair(TreeNode r,int d){
                root=r;
                dist=d;
            }
        }
        Queue<pair>que=new LinkedList<>();
        if(A!=null){
            pair p=new pair(A,0);
            que.add(p);
        }
        while (!que.isEmpty()){
            pair temp=que.poll();
            ArrayList<Integer> t=hm.getOrDefault(temp.dist, new ArrayList<>());
            t.add(temp.root.date);

            hm.put(temp.dist,t);
            if(temp.root.left!=null) {
                pair l=new pair(temp.root.left,temp.dist-1);
                que.add(l);
            }
            if(temp.root.right!=null) {
                pair l=new pair(temp.root.right,temp.dist+1);
                que.add(l);
            }
        }
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
            //Arrays.sort(temparr);
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
        hm.clear();
        int [][] vorder=verticalOrderTraversal(root);
        System.out.println("vertical order "+ Arrays.deepToString(vorder));
    }
}
