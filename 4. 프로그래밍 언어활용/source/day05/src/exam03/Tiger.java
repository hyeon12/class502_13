package exam03;

public class Tiger extends Animal {

    @Override
    public void move() {
        System.out.println("네발로 뛰어다닌다.🐱");
    }

    public void hunting() {
        System.out.println("사냥을 한다.🍖");
    }
    /*
    @Override
    public void move() {
        super.move(); //상위 클래스(Animal)의 메서드(move()) 호출
    }
     */
}
