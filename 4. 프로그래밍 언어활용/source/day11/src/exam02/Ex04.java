package exam02;

public class Ex04 {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple());

        Juicer.make2(appleBox);// Apple, Fruit, Object

        FruitBox<Fruit> grapeBox = new FruitBox<>();
        grapeBox.add(new Grape()); //Fruit fruit = new Grape();
        Juicer.make2(grapeBox);

        /*
        FruitBox<Grape> grapeBox = new FruitBox<>();
        grapeBox.add(new Grape());
        Juicer.make2(grapeBox);
        */
    }
}
