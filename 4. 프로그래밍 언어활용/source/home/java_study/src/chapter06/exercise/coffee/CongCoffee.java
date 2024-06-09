package chapter06.exercise.coffee;

public class CongCoffee {

    int money;

    public String sell(int money) {
        this.money += money;
        if (money == Menu.CONGAMERICANO) {
            return " 콩 다방 아메리카노를 구입했습니다.";
        } else if (money == Menu.CONGLATTE) {
            return " 콩 다방 라떼를 구입했습니다.";
        } else {
            return null;
        }
    }

}
