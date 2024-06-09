package chapter06.exercise.coffee;

public class Person {
    String name;
    int money;

    public Person(String name, int money){
        this.name = name;
        this.money = money;
    }

    public void buyStarCoffee(StarCoffee starCoffee, int money){
        String message = starCoffee.sell(4000);
        if(message != null){
            this.money -= money;
            System.out.println(name + " 씨 가 " + money + "원을 내고" + message);
        }
    }

    public void buyCongCoffee(CongCoffee congCoffee, int money){
        String message = congCoffee.sell(4500);
        if(message != null) {
            this.money -= money;
            System.out.println(name + " 씨 가 " + money + "원을 내고" + message);
        }
    }
}
