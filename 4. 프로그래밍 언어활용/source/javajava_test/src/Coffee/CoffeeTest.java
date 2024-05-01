package Coffee;

public class CoffeeTest {
    public static void main(String[] args) {
        Person lee = new Person();
        Person kim = new Person();
        lee.setName("이");
        kim.setName("김");

        BeanCoffee beanCoffee = new BeanCoffee();
        StarCoffee starCoffee = new StarCoffee();

        kim.getName();
        starCoffee.order("아메리카노");
        starCoffee.make("아메리카노");

        lee.getName();
        beanCoffee.order("라떼");
        beanCoffee.make("라떼");
    }
}
