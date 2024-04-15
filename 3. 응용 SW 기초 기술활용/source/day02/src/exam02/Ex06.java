package exam02;

import java.util.Arrays;

public class Ex06 {
    public static void main(String[] args) {
        int[][] nums = {{10, 20, 30}, {40, 50, 60}};
        System.out.println(nums); // 배열이 시작되는 주소값
        //System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.deepToString(nums));
        /*
        System.out.println(nums.length); // 행의 갯수
        System.out.println(nums[0].length); // 1행의 열의 갯수
        System.out.println(nums[1].length); // 2행의 열의 갯수

        for (int i = 0; i < nums.length; i ++) { // 행
            for (int j = 0; j < nums[i].length; j++) { //열
                System.out.println(nums[i][j]); // i행, j열
            }
        }
         */
    }
}
