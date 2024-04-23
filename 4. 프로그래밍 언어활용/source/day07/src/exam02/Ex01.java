package exam02;

public class Ex01 {
    public static void main(String[] args) {
        try {
            int num1 = 10;
            int num2 = 2;
            int result = num1 / num2; // ArithmeticException 10/0

            String str = null;
            System.out.println(str.toUpperCase()); // NullPointerException

            System.out.println(result);
        } catch (ArithmeticException e){
            e.printStackTrace();
        } catch (Exception e){ //예외가 발생했는데 무슨 예외인지 모를때!
            System.out.println("유입!");
            e.printStackTrace();
        }
        System.out.println("매우 중요한 코드");
    }
}
