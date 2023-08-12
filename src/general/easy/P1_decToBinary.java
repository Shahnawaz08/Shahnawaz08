package general.easy;
import java.lang.*;
import java.util.*;

public class P1_decToBinary {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            long bin = 0;
            long mul = 1;
            while (N > 0) {
                long rem = N % 2;
                rem = rem * mul;
                bin = bin + rem;
                mul = mul * 10;
                N = N / 2;
            }
            System.out.println(bin);
        }
    }

}
