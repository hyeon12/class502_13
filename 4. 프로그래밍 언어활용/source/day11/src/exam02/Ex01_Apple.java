package exam02;

public class Ex01_Apple {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>(); //사과를 담아 사과주스
        appleBox.add(new Apple()); //add() 사과를 박스에 담았다!
        appleBox.add(new Apple()); //사과를 한개 더 담자!

        Juicer.make(appleBox); // make() 주스를 만들자!
    }
}
