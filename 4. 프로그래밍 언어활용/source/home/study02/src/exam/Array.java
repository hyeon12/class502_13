package exam;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5};
        Arrays.sort(arr);
        int center = arr.length / 2;
        int answer = arr[center];
        /*
        Arrays.sort(arr);
        int center = arr.length / 2;
        System.out.println(arr[center]);
        System.out.println(Arrays.toString(arr));
    */
    }

}
