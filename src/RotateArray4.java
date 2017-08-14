// reversal algorithm for array rotation
//
// Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements
// Algorithm:
// reverse(arr[], 1, d)
// reverse(arr[], d + 1, n)
// reverse(arr[], 1, n)
//
// let AB be the two parts of the input array where A = arr[0...d-1] and B = [d...n-1]. The idea of the
// algorithm is:
// Reverse A to get ArB. /* Ar is reverse of A */
// Reverse B to get ArBr. /* Br is reverse of B */
// Reverse all to get (ArBr)r = BA

public class RotateArray4 {

    static void rotate(int arr[], int d, int arSize){
        reverseArr(arr, 0, d - 1);
        reverseArr(arr, d, arSize - 1);
        reverseArr(arr, 0, arSize - 1);

        // print array
        for(int i = 0; i < arSize; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // reverse the array with start and end indices
    static void reverseArr(int arr[], int start, int end){
        int temp;
        while(start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){

        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int arSize = arr.length;
        int d = 2;

        rotate(arr, d, arSize);
    }
}
