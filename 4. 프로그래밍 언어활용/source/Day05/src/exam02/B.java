package exam02;

public class B extends A { //B가 A를 상속받는 관계로 클래스에 정의
    int numB = 20;
    //클래스생성자 내부에는 기본 생성자가 추가되어 객체 생성됨 (보이지 않아도 포함되어있음)
    public B() {
        super(); // A클래스에 정의된 A();
        System.out.println("B 생성자!");
    }
}
