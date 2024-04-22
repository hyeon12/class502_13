package exam01;

public abstract class Calculator {
    int num = 10;

    public Calculator() {
        System.out.println("Calculator 생성자!");
    }

    public abstract int add(int num1, int num2); //이대로는 객체 생성x

    public final void commonMethod(){ // 공통적인 자원 정의 가능

    }
}
