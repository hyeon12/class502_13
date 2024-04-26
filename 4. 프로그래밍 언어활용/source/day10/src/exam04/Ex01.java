package exam04;

public class Ex01 {
    public static void main(String[] args) {
        Box appleBox = new Box();
        appleBox.setItem(new Apple()); //생성과 동시에 담기 !

        //Object apple = appleBox.getItem();
        //Box에서 자료형 Object 했으므로, 자료형:Apple 하면 오류!
        //반환값을 꺼내기 위해서 명시적 형변환 해야함

        Apple apple = (Apple)appleBox.getItem();
        System.out.println(apple.get());

        Box grapeBox = new Box();
        grapeBox.setItem(new Grape());

        if (grapeBox.getItem() instanceof Apple) {
            // 타입 안정성이 떨어지는 문제 - 매번 타입 확인해야 하고... 오류가 발생하기 쉬움
            Apple grape = (Apple) grapeBox.getItem();
            System.out.println(grape.get());
        }
    }
}
