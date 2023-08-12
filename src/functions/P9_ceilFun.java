package functions;

import java.util.Scanner;

public class P9_ceilFun {
    public  static int areaOfCircle(int rad){
        float area=(float)Math.PI*rad*rad;
        int intarea=(int)area;
        float d=area-intarea;
        System.out.println("diff of area and intareea"+d);
        if(d>0){
            return intarea+1;
        }
        return intarea;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        System.out.println(areaOfCircle(r));

    }
}
