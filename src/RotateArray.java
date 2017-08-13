// Write a function rotate(arr[], d, n) that rotates arr[] of n by d element


public class RotateArray {

    // Method (use temp array)
    // 1. Store d elements in a temp array
    // 2. Shift rest of the array
    // 3. Store back the d array
    static void rotate(int arr[], int d, int arrSize){

        // store d elements in temp array
        int temp[] = new int[d];
        for(int i = 0; i < d; i++){
            temp[i] = arr[i];
        }

        // Shift the rest of the array and store back the d elements
        for(int i = 0; i < arrSize; i++){
            if(i < (arrSize - d)) {
                arr[i] = arr[i + d];
            } else {
                arr[i] = temp[i - (arrSize - d)];
            }
        }

        // print array
        for(int i = 0; i < arrSize; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Method ()
    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int arrSize = arr.length;
        int d = 2;

        rotate(arr, d, arrSize);
    }
}
