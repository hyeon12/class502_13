import java.sql.SQLOutput;

public class Ex01 {
    public static void main(String[] args) {
        Person kim = new Person("김 씨");
        Person lee = new Person("이 씨");

        CoffeeBean coffeebean = new CoffeeBean();
        StarCoffee starCoffee = new StarCoffee();

        kim.buy();
        coffeebean.make("라떼");
        lee.buy();
        starCoffee.make("아메리카노");
    }
}
