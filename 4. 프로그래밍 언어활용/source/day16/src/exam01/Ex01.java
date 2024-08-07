package exam01;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11, 13};
        boolean isOdd = Arrays.stream(nums).allMatch(x -> x % 2 == 1);//모두 참일때
        System.out.println(isOdd);

        boolean isEven = Arrays.stream(nums).anyMatch(x -> x % 2 == 0);//하나라도 참일때
        System.out.println(isEven);

        boolean notIncludedEven = Arrays.stream(nums).noneMatch(x -> x % 2 == 0);//전부 거짓일때
        System.out.println(notIncludedEven);
        /*
        boolean result = true;
        for(int num : nums) {
            if(num % 2 == 0){
                result = false;
                break;
            }
        }
         */
    }
}
