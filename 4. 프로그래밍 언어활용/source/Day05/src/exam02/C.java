package exam02;

public class C extends B {
    int numC = 30;

    //디폴트생성자(기본생성자) ... 객체를 생성하는 역할 (보이지 않아도 존재한다!)
    public C() {
        super(); // B클래스에 정의된 B()
        System.out.println("C 생성자!");
    }
}
