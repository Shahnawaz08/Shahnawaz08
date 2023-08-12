package AdvanceDSA.Backtracking;

import java.util.*;

public class P3_AllUniquePermutation {
    //static int [][] twoDArray;
    static ArrayList<ArrayList<Integer>> twoDArray;
    static int row=0;
    public static int fact(int n){
        int fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }
    public static void permuteHelper(int[] input, int i, int n){
        //base case
        if(i==input.length){
//            int [] temp=input.clone();
//            twoDArray[row]=temp;
//            row++;
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=0;j<input.length;j++){
                temp.add(input[j]);
            }
            twoDArray.add(temp);
            return;
        }
        //rec case
        for(int j=i;j<n;j++){
            //swap a[i],a[j];
            int temp=input[i];
            input[i]=input[j];
            input[j]=temp;
            permuteHelper(input,i+1,n);
            //swap a[i],a[j];
            temp=input[i];
            input[i]=input[j];
            input[j]=temp;

        }

    }

    public static int[][] permute(int[] A) {

        twoDArray=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        permuteHelper(A,0,A.length);
        //System.out.println(twoDArray);
        HashSet<ArrayList<Integer>> set=new HashSet<>();

        for (ArrayList<Integer> ar:twoDArray){
            set.add(ar);
        }
        //System.out.println(set);
        twoDArray.clear();
        for(ArrayList<Integer> ar:set){
            twoDArray.add(ar);
        }

        Collections.sort(twoDArray,(ArrayList<Integer> a ,ArrayList<Integer> b)->{
            int l1=a.size();
            int l2=b.size();
            int min=l1<l2?l1:l2;
            for(int i=0;i<min;i++){
                if(a.get(i)<b.get(i)){
                    return -1;
                }
                if(a.get(i)>b.get(i)){
                    return 1;
                }
            }
            if(l1<l2){
                return -1;
            }
            return 1;
        });
        int [][] final_array=new int[twoDArray.size()][];
        int idx=0;
        for(ArrayList<Integer> ar:twoDArray){
            int [] temp=ar.stream().mapToInt(i->i).toArray();
            final_array[idx]=temp;
            idx++;
        }


        //System.out.println(twoDArray);
        return final_array;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] A=new int[N];
        for(int i=0;i<N;i++){
            A[i]=sc.nextInt();
        }
        int [][] res=permute(A);
        System.out.println(Arrays.deepToString(res));
    }
}
