package AdvanceDSA.HeapProblem;

public class MaxHeap {
    //Data member
    int [] arr; //container
    int capacity; //maxSize
    int size;//currentSize

    //Init /constructor
    MaxHeap(int maxLimit){
        capacity=maxLimit;
        size=0;
        arr=new int[capacity+1];
    }
    //methods
    //TC : O(LogN)
    void insert(int data){
        size=size+1;
        if(size<=capacity+1) {
            int idx=size;
            //insert at the ending of array
            arr[idx]=data;
            //fix the heap
            while (idx > 1 && arr[idx] > arr[idx/2]) {
                int temp=arr[idx];
                arr[idx]=arr[idx/2];
                arr[idx/2]=temp;
                idx=idx/2;
            }

        }

    }
    //Tc :O(1)
    int getMax(){
        if(size>=1){
            return arr[1];
        }
        return -1;
    }

    //TC : O(LogN)
    void removeMax(){
        //swap max and the end element
        int temp=arr[size];
        arr[size]=arr[1];
        arr[1]=temp;

        //decrease to the size
        size=size-1;

        //heapification
        int idx=1;
        while (idx<=size){
            int maxidx=idx;
            int left=2*idx;
            int right=2*idx+1;
            if(left<=size&&arr[left]>arr[idx]){
                maxidx=left;
            }
            if(right<=size&&arr[right]>arr[maxidx]){
                maxidx=right;
            }
            if(maxidx==idx) break;
            //swap the max element to the element at index idx
            int temp2=arr[idx];
            arr[idx]=arr[maxidx];
            arr[maxidx]=temp2;
        }
    }

}
