// Given an array A[] and a number x, check for pair in A[] with sum as x.
// Algorithm:
//  hasArrayTwoCandidates(arr[], arSize, sum)
//   1. Sort the array in non-decreasing order
//   2. Initialize two index variables to find the candidate elements in the sorted array
//      a) Initialize first to the leftmost index: l = 0
//      b) Initialize second the rightmost index: r = arSize - 1
//   3. Loop while l < r
//      a) If(A[l] + A[r] == sum) then return 1
//      b) Else if(A[l] + A[r] < sum) then l++
//      c) Else r--
//   4. No candidates in whole array - return 0.
//
//   Time Complexity:
//      - Depends on what sorting algorithm we use.
//          if we use merge sort or heap sort then (nlogn) in worst case
//          if we use quick sort then O(n^2) in worst case.
//      - Auxilliary Space:
//          Again, depends on sorting algorithm. For example auxillary space is O(n) for merge and O(1) for heap sort.

public class PairSumArray {

    static boolean hasArrayTwoCandidates(int arr[], int arSize, int sum){
        quickSort(arr, 0, arSize - 1);

        // print array
//        for(int k = 0; k < arSize; k++){
//            System.out.print(arr[k] + " ");
//        }
//        System.out.println();

        int left = 0;
        int right = arSize - 1;

        while(left < right){
            if(arr[left] + arr[right] == sum) {
                return true;
            } else if (arr[left] + arr[right] > sum) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    static void quickSort(int arr[], int low, int high){

        if(low < high){

            int pIndex = partition(arr, low, high);

            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    static int partition(int arr[], int low, int high){

        int pivot = arr[high];

        int i = (low - 1); // -1

        for(int j = low; j <= high - 1; j++){

            //if the current element is smaller than or equal to pivot
            if(arr[j] <= pivot){

                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args){

        int arr[] = {1, 4, 45, 6, 10, -8};
        int arSize = 6;
        int sum = 45;

        System.out.println(hasArrayTwoCandidates(arr, arSize, sum));
    }
}
