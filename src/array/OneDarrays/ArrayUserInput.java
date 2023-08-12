package array.OneDarrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayUserInput {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int [] arr=new int[N];
        System.out.println(arr);
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));
        // Read N elements,loop runs N times
        for (int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
    }
}
