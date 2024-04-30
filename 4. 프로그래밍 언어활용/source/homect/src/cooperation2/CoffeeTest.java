package cooperation2;

public class CoffeeTest {
    public static void main(String[] args) {

        Person kim = new Person("kim", 10000);
        Person lee = new Person("lee", 10000);
        StarCoffee starCoffee = new StarCoffee();
        BeanCoffee beanCoffee = new BeanCoffee();

        kim.buyCoffee(starCoffee, "아메리카노");
        lee.buyCoffee(beanCoffee, "라떼");


    }
}
