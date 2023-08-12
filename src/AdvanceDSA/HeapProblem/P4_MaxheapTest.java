package AdvanceDSA.HeapProblem;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P4_MaxheapTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        MaxHeap mh=new MaxHeap(N);
        for (int i=0;i<N;i++){
            int no=sc.nextInt();
            mh.insert(no);
        }
        System.out.println(Arrays.toString(mh.arr));

    }
}
