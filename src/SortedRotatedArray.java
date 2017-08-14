// Search an element in a sorted and rotate array
// An element in a sorted array can be found in O(log n) time via binary search.
// But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
// So for instance 1, 2, 3, 4, 5 might become 3, 4, 5, 1, 2. Devise a way to find an element in the
// rotated array in O(log n) time.
//
// Assume that all elements in array are distinct
// - The idea is to find pivot point, divide the array into two sub-arrays and call binary search.
// - The main idea for finding pivot is - for a sorted(in increasing order) and pivoted array, pivot
//   element is the only element for which next element to its is smaller than it.
//   using above criteria and binary search methodology we can get pivot element in O(log n) time.
//
// Input arr[] = {3, 4, 5, 1, 2}
// Element to search = 1
// 1. Find out pivot point and divide the array in two sub-arrays (pivot = 2) /* index of 5 */
// 2. Now call binary search for one of the two sub-arrays
//      a) if element is greater than 0th element then search in left array
//      b) else search in right array (1 will go in else as 1 < 0th element(3))
// 3. If element is found in selected sub-array then return index. Else return -1.

public class SortedRotatedArray {

    static int pivotedBinarySearch(int arr[], int arSize, int key){
        int pivot = findPivot(arr, 0, arSize - 1);

        if(pivot == -1)
            return binarySearch(arr, 0, arSize - 1, key);

        if(arr[pivot] == key)
            return pivot;

        if(arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);

        return binarySearch(arr, pivot + 1, arSize - 1, key);
    }

    static int findPivot(int arr[], int low, int high){

        if(high < low)
            return -1;
        if(high == low)
            return low;

        int mid = (low + high) / 2;
        if(mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if(mid > high && arr[mid] < arr[mid - 1])
            return (mid - 1);

        if(arr[low] >= arr[mid])
            return findPivot(arr, low, mid -1);

        return findPivot(arr, mid + 1, high);
    }

    static int binarySearch(int arr[], int low, int high, int key){
        if(high < low)
            return -1;

        int mid = (low + high) / 2;
        if(key == arr[mid])
            return mid;

        if(key > arr[mid])
            return binarySearch(arr, mid + 1, high, key);

        return binarySearch(arr, low, mid - 1, key);
    }

    public static void main(String[] args){
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int arSize = arr.length;
        int key = 10;

        int keyIndex = pivotedBinarySearch(arr, arSize, key);
        System.out.println(keyIndex);
    }
}
