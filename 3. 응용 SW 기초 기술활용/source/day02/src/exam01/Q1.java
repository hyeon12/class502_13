package exam01;

public class Q1 {
    public static void main(String[] args) {
        int num1 = 20;
        double num2 = 3.9;

        int result = (int)(num1 * num2); // 자동으로 int num1 -> double 변환하고 연산
        // 연산결과를 int 정수로 변환

        System.out.println(result);
    }
}

