package AdvanceDSA.GraphProblems;

import java.util.*;

public class P10_ConstructRoads {
    public static boolean bipartiteBfs(ArrayList<ArrayList<Integer>> adj,int i,int [] colour){
        Queue<Integer> q=new LinkedList<>();
        // int defaultColour=1;
        // for(int neb: adj.get(i)){
        //     if(colour[neb]!=-1){
        //         defaultColour=1-colour[neb];
        //     }
        // }
        // colour[i]=defaultColour;
        colour[i]=1;
        q.add(i);
        while (!q.isEmpty()){
            int ver=q.poll();
            for(int nebour: adj.get(ver)){
                //if nebour is not colour we colour it is opposite colour of current vertex
                if(colour[nebour]==-1){
                    colour[nebour]=1-colour[ver];
                    q.add(nebour);
                }
                //if nebour is already colour and it is same so bipartite is not possible
                else if (colour[nebour]==colour[ver]){
                    return false;
                }
            }
        }
        return true;
    }
    public static int solve(int A, int[][] B) {
        //create an adjacency list
        ArrayList<ArrayList<Integer>> adj =new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=A;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<B.length;i++){
            ArrayList<Integer> nebour1=adj.get(B[i][0]);
            ArrayList<Integer> nebour2=adj.get(B[i][1]);
            nebour1.add(B[i][1]);
            nebour2.add(B[i][0]);
        }
        System.out.println(adj);
        //creating a colour array
        int [] colour=new int[A+1];
        Arrays.fill(colour,-1);
        //since graph can be disconnected so we have to run bipartite for
        //every component
//        for(int i=0;i<A;i++){
//            if(colour[i]==-1){
//                if(!bipartiteBfs(adj,i,colour)){
//                    return 0;
//                }
//            }
//        }
        boolean is =bipartiteBfs(adj,1,colour);
        System.out.println(Arrays.toString(colour));
        long fst=0;
        long sec=0;
        for(int i=1;i<colour.length;i++){
            if(colour[i]==1) fst++;
            else sec++;
        }
        long totaledge=fst*sec;
        long roadToConst=totaledge-(A-1);
        return (int)(roadToConst%1000000007);


        //return 1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Number of nodes is ");
        int A=sc.nextInt();
        System.out.println("Number of edges followed by the edges");
        int M=sc.nextInt();
        int [][]B=new int[M][2];
        for(int i=0;i<M;i++){
            for(int j=0;j<2;j++){
                B[i][j]=sc.nextInt();
            }
        }
        int isbipartite=solve(A,B);
        if(isbipartite==1) System.out.println("Graph is bipartite");
        else System.out.println("Geraph is not bipartite");

    }
}
