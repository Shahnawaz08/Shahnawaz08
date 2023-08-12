package array.TwoDArray;

public class P6_ArraySortedBYBothRowsAndCol {
    public static void stairCaseSearch(int[][]arr,int num){
        int row=0;
        int col=arr[0].length-1;
        int emt;
        while (true){
            emt=arr[row][col];
            if(emt==num){
                System.out.println("Element found at ["+row+"]["+col+"]");
                break;
            }
            else if(emt<num){
                row++;
            }
            else{
                col--;
            }
        }
    }
    public static void stairCaseSearch2(int[][]arr,int num){
        int row= arr.length-1;
        int col=0;
        int emt;
        while (true){
            emt=arr[row][col];
            if(emt==num){
                System.out.println("Element found at ["+row+"]["+col+"]");
                break;
            }
            else if(emt<num){
                col++;
            }
            else{
                row--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr={{1,2,3,4},
                    {5,6,9,12},
                    {8,13,15,18},
                    {10,20,30,40}};
        stairCaseSearch(arr,6);
        stairCaseSearch2(arr,6);
    }
}
