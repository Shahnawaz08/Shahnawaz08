package array.TwoDArray;

public class P5_TwoDArraywavePrint {
    public static void wavePrint(int[][]arr){
        int rows= arr.length;
        int cols=arr[0].length;
        for(int i=0;i<cols;i++){
            if(i%2==0) {
                for (int j = 0; j < rows; j++) {
                    System.out.print(arr[j][i] + " ");
                }
            }
            else{
                for(int j=rows-1;j>=0;j--){
                    System.out.print(arr[j][i]+" ");
                }
            }

        }
    }

    public static void main(String[] args) {
        int[][] arr={{1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,16}};
        wavePrint(arr);
    }

}
