package main.java.Algorithms;

public class Sort {

    public int[] bubbleSort(int arr[]){
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-i-1;j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    public void mergeSort(int[] arr, int leftP, int rightP){
        if(leftP < rightP){
            int middle = (leftP + rightP)/2;
            //sort each half
            mergeSort(arr, leftP, middle);
            mergeSort(arr, middle + 1, rightP);


            //merge
            merge(leftP,middle, rightP);



        }



    }

    public void mergeSortMerge(int arr[], int l, int m, int r){
        //find sizes of two subarrays to be merged
        int n1 = m - l + r;
        int n2 = r - m;

        //create temp arrays
        int L[] = new int [n1];
        int R[] = new int [n2];

        //copy data to temp arrays
        for(int i = 0; i <n1; i++){
            L[i] = arr[l + i];
        }
        for(int j = 0; j <n2; j++){
            R[j] = arr[m + 1 + j];
        }


    }

}
