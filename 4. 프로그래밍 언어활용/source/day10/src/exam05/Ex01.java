package exam05;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<Apple>(); //<명시한 자료형>이 담긴다
        appleBox.setItem(new Apple()); // 타입 명시함으로써 타입 안정성 : 실행하기 전 오류 발생!!
        //appleBox.setItem(new Grape()); -> 오류

        Grape apple = appleBox.getItem(); //형변환의 번거로움 X
        System.out.println(apple.get());

        Box <Grape> grapeBox = new Box<Grape>();
    }
}
