package exam03;

public class Ex05 {
    public static void main(String[] args) {
        int num1 = 100;
        Integer num2 = Integer.valueOf(200);
        //기본형끼리/같은자료형끼리만 연산가능 -> num1,num2 연산 불가능!
        int result1 = num1 + num2; // num2.intValue()
        System.out.println(result1);
        //왜 가능할까? 컴파일러가 num2를 num2.intValue()로 자동 변환

        Integer num3 = Integer.valueOf(100);
        Integer num4 = Integer.valueOf(200);

        int result2 = num3 + num4; //num3.intValue() + num4.intValue()
        System.out.println(result2);
    }
}
