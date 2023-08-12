package array.OneDarrays;


import java.util.Arrays;

public class P7_SortArray {
    public static void reverse(int[] arr) {
        int s=0;
        int e=arr.length-1;
        while (s<e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }

    }

    public static void main(String[] args) {
        int [] arr={1,23,4,5,2,1,8,27};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
}
