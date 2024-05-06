package study;

public class solution {
    // numbers_len은 배열 numbers의 길이입니다.
    double solution(int numbers[]) {
        double total = 0;
        for (int i = 0; i <= numbers.length; i++) {
            total += numbers[i];
        }
        double answer = total/numbers.length;
        return answer;
    }
}
