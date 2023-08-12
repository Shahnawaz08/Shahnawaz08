package array.OneDarrays;

import java.util.Arrays;

public class P1_ArrayPriint {
    public static void main(String[] args) {
        int [] arr={10,20,22,20,50};
        //print using for loop
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        //print using foreach loop
        for (int m:arr) {
            System.out.print(m+" ");
        }
        System.out.println();
        System.out.println(Arrays.toString(arr));
    }
}
