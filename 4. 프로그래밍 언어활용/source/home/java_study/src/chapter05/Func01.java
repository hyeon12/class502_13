package chapter05;

public class Func01 {
    public static double divide(int num1, int num2){
        if(num2 == 0){
            throw new IllegalArgumentException("나누는 수는 0이 될 수 없습니다.");
        } else {
            int result = num1 / num2;
            System.out.println(num1 + "/" + num2 + "=" + result);
            return result;
        }
    }

    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 5;
        int n3 = 0;
        try {
            double div = divide(n1, n2);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
            double div2 = divide(n1, n3);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
