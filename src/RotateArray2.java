// Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements
// Method (rotate one by one)
// To rotate one by one, store arr[0] in a temp variable
// move arr[1] to arr[0], arr[2] to arr[1] ... and finally temp to arr[n - 1]

public class RotateArray2 {

    void rotate2(int arr[], int d, int arSize) {
        for(int i = 0; i < d; i++){
            int j, temp;
            temp = arr[0];
            for(j = 0; j < arSize - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = temp;
        }
    }

    void print(int arr[], int arSize){
        for(int i = 0; i < arSize; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int arSize = arr.length;
        int d = 2;

        RotateArray2 rotateArr = new RotateArray2();

        rotateArr.rotate2(arr, d, arSize);
        rotateArr.print(arr, arSize);
    }
}
