package Coffee_practice;

public class CoffeeTest {
    public static void main(String[] args) {
        Person kim = new Person("kim", 10000);
        Person lee = new Person("lee", 10000);
        Coffee starCoffee = new StarCoffee();
        Coffee beanCoffee = new BeanCoffee();

        kim.buyCoffee(beanCoffee, "라떼");
        lee.buyCoffee(starCoffee, "아메리카노");
    }
}
