package cooperation;

public class CoffeeTest {
    public static void main(String[] args) {

        Person kim = new Person("kim", 4000);
        Person lee = new Person("lee", 4500);
        StarCoffee starCoffee = new StarCoffee();
        BeanCoffee beanCoffee = new BeanCoffee();

        kim.buyStarCoffee(starCoffee, 4000);
        lee.buyBeanCoffee(beanCoffee, 4300);


    }
}
