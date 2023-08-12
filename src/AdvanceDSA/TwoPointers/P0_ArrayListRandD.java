package AdvanceDSA.TwoPointers;

import java.util.*;

public class P0_ArrayListRandD {
    public static void main(String[] args) {
        HashSet<ArrayList<Integer>> hm=new HashSet<>();
        int [] arr={1,2,3};
        List<Integer> list=Arrays.asList(1, 2, 3);
        ArrayList a1=new ArrayList(list);
        List<Integer> list2=Arrays.asList(1, 2, 3);
        ArrayList a2=new ArrayList(list2);
        List<Integer> list3=Arrays.asList(1, 2, 4);
        ArrayList a3=new ArrayList(list3);
        hm.add(a1);
        hm.add(a2);
        hm.add(a3);
        System.out.println(hm);
    }
}
