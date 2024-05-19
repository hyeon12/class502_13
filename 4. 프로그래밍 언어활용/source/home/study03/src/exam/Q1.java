package exam;

public class Q1 {
    public static void main(String[] args) {
        int[] array = {7, 77, 17};

        Solution solution = new Solution();

        int result = solution.solution(array);
        System.out.println(result);
    }

    static class Solution {
        public int solution(int[] array) {
            int cnt = 0;
            for (int number : array) {
                // 각 요소를 문자열로 변환
                String numberStr = String.valueOf(number);
                System.out.println("숫자: " + number + " -> 문자열: " + numberStr);
                // 문자열에서 '7'의 개수 세기
                for (char c : numberStr.toCharArray()) {
                    if (c == '7') {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }
}
