package array.IntermidiateArrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P10_minSwitch {
    public static int solve(int[] A) {
        int nSwitch = 0;
        int N = A.length;
        for (int i = 0; i < N; i++) {
            if (A[i] == 0) {
                for (int j = i; j < N; j++) {
                    A[j] = 1 - A[j];
                    //System.out.println(Arrays.toString(A));
                }
                nSwitch++;
            }
        }

        return nSwitch;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array followed by elements");
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int len = solve(A);
        System.out.println("Minimum subarray containing min element and max element is " + len);
    }
}
