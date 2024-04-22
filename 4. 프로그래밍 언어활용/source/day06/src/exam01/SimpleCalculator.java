package exam01;

public class SimpleCalculator extends Calculator{

    public SimpleCalculator(){
        super(); //Calculator() 호출 -> 내부적으로 Calculator가 객체가 됨.
    }

    public int add(int num1, int num2){
        return num1 + num2; // 메서드 재정의 -> 상속과 관련
    }

    //public void commonMethod(){} // 상위클래스의 메서드에 final -> 재정의 불가
}
