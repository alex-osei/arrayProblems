//Given an array, cyclically rotate the array clockwise by one
//
// Ex: inputs arr[] = {1, 2, 3, 4, 5}
//     outputs arr[] = {5, 1, 2, 3, 4}
//
// following are steps:
// 1. Store last element in a variable say x
// 2. Shift all elements one position ahead
// 3. Replace first element of array with x

import java.util.Arrays;

public class RotateArray5 {

    static int arr[] = new int[] {1, 2, 3, 4, 5, 6, 7};

    static void rotate(){
        int lastItem = arr[arr.length - 1];
        for(int i = arr.length - 1; i > 0; i--){
            arr[i] = arr[i - 1];
        }
        arr[0] = lastItem;
    }

    public static void main(String[] args){

        System.out.println("Given Array is: ");
        System.out.println(Arrays.toString(arr));
        rotate();
        System.out.println();
        System.out.println("Rotated Array is: ");
        System.out.println(Arrays.toString(arr));
    }
}
