package Coffee_practice;

public class Person {
    String name;
    int money;

    Person(String name, int money){
        this.name = name;
        this.money = money;
    }

    public void buyCoffee(Coffee coffee, String name){

        int price = coffee.getPrice(name);

        if(money >= price){
            money -= price;
        }

        String message = coffee.brewing(name);
        System.out.printf("%s씨가 %s, 남은 금액은 %d 입니다.%n", this.name, message, money);
    }
}
