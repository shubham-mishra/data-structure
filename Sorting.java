package Sortings;

public class Sorting {
        
    public void bubbleSort(int arr[], int size){
        
        for( int i = size - 1; i > 0; --i){
            for(int j = 0; j <= i - 1; ++j){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                
            }
        }
    }
    
    public void insertionSort(int arr[], int size){
        
        for(int i = 1; i < size; i++){
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
    
    public void selectionSort(int arr[], int size){
        
        for(int i = 0; i < size - 2; ++i){
            for(int j = i+1; j < size - 1; ++j){
                if(arr[j] < arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    
    //here merge sort starts.
    public void mergeSort(int arr[], int size){
        divide(arr, 0, size - 1);
    }

    private void divide(int[] arr, int l, int r) {
        if(l < r){
            int mid = (l+r)/2;
            divide(arr, l, mid);
            divide(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int temp_arr[] = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        
        while(i <= mid && j <= r){
            if(arr[i] < arr[j]){
                temp_arr[k++] = arr[i++];
            }else{
                temp_arr[k++] = arr[j++];
            }
        }
        
        while(i <= mid){
            temp_arr[k++] = arr[i++];
        }        
        
        while(j <= r){
            temp_arr[k++] = arr[j++]; 
        }
        
        for(i=0, j=l; i < k; i++, j++){
            arr[j] = temp_arr[i];
        }
    }
    //here merge sorts ends.
    
    
    //quick sort starts.
    public void quickSort(int arr[], int size){
        sort(arr, 0, size-1);
    }

    private void sort(int[] arr, int l, int r) {
        if(l < r){
            System.out.println("run");
            int pivot = findPivot(arr, l, r);
            sort(arr, l, pivot - 1);
            sort(arr, pivot + 1, r);
        }
    }

    private int findPivot(int[] arr, int l, int r) {
        int pivot = arr[r];
        int j = l - 1;
        int i;
        for(i = l; i < r; i++){    
            if(arr[i] < pivot){
                j++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        
        arr[r] = arr[j+1];
        arr[j+1] = pivot;
        
        return j+1;
    }
    //quick sort ends.
}
