package cooperation;

public class BeanCoffee {
    int money;

    public String brewing(int money) {
        if (money == Menu.BEANAMERICANO){
            return "콩다방 아메리카노를 구입했습니다.";
        } else if (money == Menu.BEANLATTE){
            return "콩다방 라떼를 구입했습니다.";
        } else {
            return "주문 실패";
        }
    }
}