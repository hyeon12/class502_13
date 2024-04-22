package exam02;

public abstract class Car {
    public abstract void start();
    public abstract void press();
    public abstract void turnoff();
    //순서 있는 절차를 정의하는 것

    public final void run() { //템플릿 메서드 패턴 -> 하위클래스가 재정의하게 되면 임의로 순서 바뀌게 됨.. 따라서 final로 변경불가하게!
        start();
        press();
        turnoff();
    }
}
