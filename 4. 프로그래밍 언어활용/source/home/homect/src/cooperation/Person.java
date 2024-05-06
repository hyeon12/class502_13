package cooperation;

public class Person {
    String name;
    //int money;

    Person(String name, int money){
        this.name = name;
        //this.money = money;
    }

    public void buyStarCoffee(StarCoffee sCoffee, int money){
        String message = sCoffee.brewing(4000);
        if(message != null){
            //this.money -= money;
            System.out.printf("%s씨 가 %d원을 내고 %s%n", name, money, message);
        }
    }

    public void buyBeanCoffee(BeanCoffee bCoffee, int money){
        String message = bCoffee.brewing(4500);
        if(message != null){
            //this.money -= money;
            System.out.printf("%s씨 가 %d원을 내고 %s%n", name, money, message);
        }
    }
}