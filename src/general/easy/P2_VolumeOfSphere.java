package general.easy;

import java.util.Scanner;

public class P2_VolumeOfSphere {
    public static int solve(int A) {
         double no=(4*Math.PI*A*A*A)/3;
        //System.out.println(no);
        int intno=(int) no;
        if(no>intno){
            intno++;
        }
        return intno;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();

        int no=solve(A);
        System.out.println(no);
        System.out.println('0'-A);

    }
}
