package cooperation2;

public class Person {
    String name;
    int money;

    Person(String name, int money){
        this.name = name;
        this.money = money;
    }

    public void buyCoffee(Coffee coffee, String name) { //(커피샵이름, 커피이름)

        int price = coffee.getPrice(name); //커피가격

        if (money >= price) { //가진 돈보다 커피가격이 적으면
            money -= price; //money = money-price 거스름돈(money = money-커피가격)
            String message = coffee.brewing(name); //
            System.out.printf("%s씨가 %s, 남은 금액은 %d 입니다.%n", this.name, message, money);
        }

    }
}
