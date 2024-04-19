package exam03;

public class Bird extends Animal{
    public void move() {
        System.out.println("두 날개로 날아간다."); // 메서드 재정의
        //가상테이블 위에서 인스턴트 메서드에 한해 재정의할 수 있다!
    }

}
