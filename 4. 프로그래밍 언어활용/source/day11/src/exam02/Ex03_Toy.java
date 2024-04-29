package exam02;

public class Ex03_Toy {
    public static void main(String[] args) {
        FruitBox<Toy> toyBox = new FruitBox<>();
        toyBox.add(new Toy());
        //Juicer.make(toyBox); //Apple, Grape, Fruit만 가능
    }
}
