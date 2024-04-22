package exam03;

public class Animal {
    protected void move() { //move() 메서드 -> 인스턴스 메서드로 객체가 되어야 사용 가능
        System.out.println("움직인다!");
    }
}
/*
public abstract class Animal {
    protected abstract void move(); // 설계의 틀을 제공하는 추상클래스!
}
 */
