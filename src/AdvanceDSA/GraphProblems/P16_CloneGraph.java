package AdvanceDSA.GraphProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class P16_CloneGraph {
//    Definition for undirected graph
    static class UndirectedGraphNode {
      int label;

      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  }
  public static UndirectedGraphNode DFS(UndirectedGraphNode node,HashMap<UndirectedGraphNode,UndirectedGraphNode> hm){
   if(hm.containsKey(node)) return hm.get(node);
   UndirectedGraphNode newNode=new UndirectedGraphNode(node.label);
   hm.put(node,newNode);
   for(UndirectedGraphNode nebour: node.neighbors){
     UndirectedGraphNode nb=DFS(nebour,hm);
     newNode.neighbors.add(nb);
   }
   return newNode;
  }
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
      HashMap<UndirectedGraphNode,UndirectedGraphNode> hm=new HashMap<>();
      UndirectedGraphNode newNode=DFS(node,hm);
      return newNode;
    }
    public static UndirectedGraphNode createGraph(Scanner sc){
      int data=sc.nextInt();
      if(data==-1)
        return null;
      UndirectedGraphNode newNode=new UndirectedGraphNode(data);
      //for()
      return newNode;
    }

   public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        UndirectedGraphNode node=createGraph(sc);
        UndirectedGraphNode newNode=cloneGraph(node);

    }
}
