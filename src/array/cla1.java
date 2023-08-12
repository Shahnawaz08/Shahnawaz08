package array;

public class cla1 {
    public static int solve(int[] A, int B) {
        int index=0;
        int j=0;
        while (j<A.length){
            if(A[j]==B){
                break;
            }
        }
        if(j==A.length){
            return -1;
        }
        for(int i=0;i<A.length;i++){
            if(A[i]>B){
                index++;
            }
        }
        return index;

    }

    public static void main(String[] args) {
        int[] A={1,2,3,4,5};
        int B=3;
        int s=solve(A,B);
        System.out.println(s);
    }
}
