// Method 3(A juggling algorithm)
// 1. Instead of moving elements one by one, divide the array in different sets
// where number of sets is equal to GCD of n and d and move the elements with sets
// if GCD is 1 as is for the above example array(n = 7 and d = 2), then elements will be
// moved within one set only, we just start with temp = arr[0] and keep moving arr[l + d] and a[l]
// and finally store temp at the right place.

public class RotateArray3 {

    void rotate(int arr[], int d, int arSize){

        int i, j, k, temp;
        for(i = 0; i < gcd(d, arSize); i++){
            temp = arr[i];
            j = i;
            while(true){
                k = j + d;
                if(k >= arSize)
                    k = k - arSize;

                if(k == i)
                    break;

                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    static int gcd(int d, int arSize){

        if(arSize == 0)
            return d;
        else
            return gcd(arSize, d % arSize);
    }

    void print(int arr[], int arSize){
        for(int i = 0; i < arSize; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int arSize = arr.length;
        int d = 3;

        RotateArray3 rotateArr = new RotateArray3();

        rotateArr.rotate(arr, d, arSize);
        rotateArr.print(arr, arSize);
    }
}
