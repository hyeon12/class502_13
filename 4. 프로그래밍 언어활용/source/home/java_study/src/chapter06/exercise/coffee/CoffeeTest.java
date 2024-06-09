package chapter06.exercise.coffee;

public class CoffeeTest {
    public static void main(String[] args) {
        Person kim = new Person("김", 10000);
        Person lee = new Person("이", 10000);
        StarCoffee starCoffee = new StarCoffee();
        CongCoffee congCoffee = new CongCoffee();

        kim.buyStarCoffee(starCoffee, 4000);
        lee.buyCongCoffee(congCoffee, 4500);
    }
}
