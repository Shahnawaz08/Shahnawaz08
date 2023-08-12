package array.arrayList;

import java.util.ArrayList;
import java.util.Scanner;


public class P4_TakeInputInArrayList {
    public static ArrayList<ArrayList<Integer>> takeInput(){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<ArrayList<Integer>> arrList=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            int cols=sc.nextInt();
            arrList.add(new ArrayList<>(cols));
            for (int j=0;j<cols;j++){
                int no= sc.nextInt();
                arrList.get(i).add(no);
            }
        }
        return arrList;

    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrList=takeInput();
        for(int rows=0;rows<arrList.size();rows++){
            for(int j=0;j<arrList.get(rows).size();j++){
                System.out.print(arrList.get(rows).get(j)+" ");
            }
            System.out.println();
        }
    }
}
