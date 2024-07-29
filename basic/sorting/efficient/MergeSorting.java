package basic.sorting.efficient;


public class MergeSorting {

    public static void mergeSort(int arr[], int left, int right) {
        //if null or length is 1
        if(left >= right) {
            return;
        }

        //find middle
        int middle = (left + right )/ 2; 
        mergeSort(arr, left, middle); //divide the left side 
        mergeSort(arr, middle + 1, right); //divide the right side
        merge(arr, left, middle, right); 
    }

    public static void merge(int arr[], int left, int middle, int right) {
        //Create L = arr[left...middle] and  M = arr[middle + 1... right]
        int  n1 = middle - left + 1;
        int  n2 = right - middle;

        int leftArr[] = new int[n1];
        int middleArr[] = new int[n2];

        //merging the left side.
        for(int  i  = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        //create array from the middle up to the 
        for(int  j = 0; j < n2 - 1; j++) {
            middleArr[j] = arr[middle + 1 + j]; //
        }

        //maintain  the index for the current  index  of the subarray and main array
        int i =0 , j=0, k = 0;
        
        while(i < n1 && j < n2) {
            if(leftArr[i] <= middleArr[j]) { 
                arr[k] = leftArr[i];
                i++;
            } else { //swap them if that is  not the case
                arr[k] = middleArr[j];
                j++;
            }
        }

        //When we are out of elements in the lef or middle array, put the remaining elements into the array
        while(i < n2) {
            arr[i] = leftArr[i];
            i++;
            k++;
        }

        while(j < n2) {
            arr[k] = middleArr[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        int arr[] = {20,30,2,1,30,39,10};
        int n = arr.length;
        mergeSort(arr, 0, n);

        System.out.printf("Ordered: ");
        for(int i = 0; i < n; i++) { 
            System.out.printf("%d => ", arr[i]);
        }
    }
}