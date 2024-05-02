package exam02;

import java.util.Arrays;
import java.util.Comparator;

public class Ex12 {
    public static void main(String[] args) {
        int[] nums = {33, 10, 5, 1, 34, 4, 88, 101};
        int[] nums2 = Arrays.stream(nums).sorted().toArray();
        System.out.println(Arrays.toString(nums2));
        //sorted : 기본정렬, 정렬을 바꾸고 싶은데 stream()에는 해당 메서드X
        //일반 스트림에는 sorted(Comparator...)가 있어 바꿀 수 있다!!
        //그렇다면 일반 스트림을 바꿀 수 있는 boxed() 사용!
        int[] nums3 = Arrays.stream(nums).boxed()
                                        .sorted(Comparator.reverseOrder())
                                        .mapToInt(x -> x)
                                        .toArray();
        System.out.println(Arrays.toString(nums3));
    }
}
