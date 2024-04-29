package exam02;

public class Ex02_Grape {
    public static void main(String[] args) {
        FruitBox<Grape> grapeBox = new FruitBox<>();
        grapeBox.add(new Grape());
        grapeBox.add(new Grape());

        Juicer.make(grapeBox);
    }
}
