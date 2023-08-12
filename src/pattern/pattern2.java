package pattern;
/*
   1     Observation
  232          1 N Rows
 34543         2 for ith each rows
4567654            n-i spaces
                   i values and value start from i
                   i-1 values start from 1 less than last printed value
 */

public class pattern2 {
    public static void main(String[] args) {
        int N=4;
        for (int i=1;i<=N;i++){
            // N-i spaces
            for(int j=1;j<=N-i;j++){
                System.out.print("  ");
            }
            // increasing numbers
            int val=i;
            for(int j=1;j<=i;j++){
                System.out.print(val +" ");
                val++;
            }
            //decreasing numbers
            // decrease the value of var by 2 in every iteration
            val=val-2;
            for(int j=1;j<=i-1;j++){
                System.out.print(val +" ");
                val--;
            }
            System.out.println();
        }
    }
}
