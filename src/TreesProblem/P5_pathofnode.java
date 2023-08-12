package TreesProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P5_pathofnode {

    public static Boolean findhelper(Node root,int B,ArrayList<Integer> arr){
        if(root==null){
            return false;
        }
        if(root.data==B){
            arr.add(root.data);
            return true;

        }
        if(findhelper(root.left,B,arr)||findhelper(root.right,B,arr)){
            arr.add(root.data);
            return true;
        }
        return false;
    }

    public static  int[] solve(Node A, int B) {
        ArrayList<Integer> arr=new ArrayList<>();
        Boolean c=findhelper(A, B,arr);
        int index=arr.size();
        int [] path=new int[index];
        for(int i=0;i<arr.size();i++){
            path[index-i-1]= arr.get(i);
        }
        return path;
    }
    public static void main(String[] args) {
        BinaryTree A=new BinaryTree();
        System.out.println("Path of node to be found");
        Scanner sc =new Scanner(System.in);
        int B=sc.nextInt();
        int [] path=solve(A.root,B);
        System.out.println(Arrays.toString(path));

    }
}
